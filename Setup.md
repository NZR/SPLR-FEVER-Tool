# Setting Up FEVER environment

This document should help you get started with FEVER, get the right info and (hopefuly) get it to run. 

See the pre-requisites at the end of this file.

----

1. Clone this repository to your local machine
2. In Eclipse, use the import function to import the "fever" folder as an Eclipse project

------
You should have 4 projects:
* fever: the core tool
* fever.models: containing the EMF models used for model differencing
* LinuxAnalyzer: a series of executable used to extract data from the Linux kernel for our own study
* TestFever: a series of test cases used during dev.
		
You should have compilation errors but all libraries should be here (check classpath of each project)
		
------

THEN : 

3. inside Eclipse, open the fever.models project, and select the models.genmod file. 
4. right click on the top most entity of that model, and select "generate model code"

-----
If all went well, and I didn't mess up the project structure, everything should *look* ok. 
(we still have a bit of work to setup the "rest").
If you try to run the "Main", it should complain about lack of commit id, and it can't find the linux repository. Moreover, the external tool we depend on still need to get setup. Let's get to it. 

Let's setup a few environment variables

-----
NOW:
 
In the "settings.properties" file of the /fever/ folder, you need to give the path to external tools and repositories

1. "*repo.path*" should point to a local Linux repository (freshly cloned!)
2. "*undertaker.script*" should point to the .sh script launching ``dumpconf'' from the Kconfigreader tool (/KconfigReader/run.sh)
3. "*cpp_stats.exe*" should point to the executable of CPPSTATS (don't worry about the .exe of the setting, this does not have to be the "exe" file, this project works on MacOS )

---

FINALLY: 

Dirty trick : the last step is here to make sure that cppstats and dumpconf have access to all their pre-reqs when invoked from the Java process. I'll improve on that later. 
Then, echo your "PATH" - in Linux and MacOS

In "settings.properties": copy paste your complete path to the "path" variable in the property file. (ewwwww! yes. i know.)

-----


_after you downloaded the source code and got it into a reasonable state in Eclipse_

-----
git clone https://github.com/torvalds/linux.git

go to linux directory
run "make menuconfig" / "make xconfig"
  this compiles the Linux Kconfig parser (zconf.tab.o for instance, required for dumpconf later on). 

----- 

## Get started

Once you installed the prereqs below (do that first please), 
you can start to dump info about feature changes. 
For the moment, there is no user interface so all the interactions should be done through the source code (Main.java). 

The program contains a string that you can replace with any commit id you wish. 
The output (in terms of touched change attribute) will be displayed in the console. 



 
--------
##Pre-requisites

CPPSTATS: 

git clonehttps://github.com/clhunsen/cppstats.git

get python-lxml (using your favorite package manager on Linux. On MacOS, a more manual approach is possible
see http://codespeak.net/lxml/

You might need to get srcML as well - depending on your system (very likely). 
The versions provided in the git hub repositories didn't work for me (Linux/MacOS). 
You can get the source from http://www.srcml.org/downloads.html, and then recompile them using CMake (which might ask for an update).

Ok, to get srcML working right, you might need to install a few libs (at a devel-level because). 
You also might have to update your CMake (minimal version 3.8.12 - ubuntu apt is stuck at .7 at the moment... )
Once you have that, make sure you get all the packages required presented in BUILD.md, and there's a bunch of them. 

If the installation of SRCML didn't work, you will only notice it when running FEVER. 
CPPSTATS will try to invoke src2srcml, or srcml2src and won't find it. This will result
in a runtime error.  Be careful. 


-----

DUMPCONF:

git clone  https://github.com/ckaestne/kconfigreader.git

go to the /kconfigreader/dumpconf folder
  edit the makefile.sh file
  change the path to the Linux directory 

run "sh make.sh"
  
  Warning - on MACOS : add the following compilation option to the Makefile : -D KBUILD_NO_NLS 
    this will avoid compilation errors, about a missing header file
    this is not necessary for Linux (Ubuntu)

If that worked for the best, you now need to modify the source code in "dumpconf.c"

What to change: 
  comment out line 253 ( fprintf(stdout, "\n.\n"); )
Why change it ? 
  because dumpconf will then produce an xml file. That specific lines adds a "." at the top of the file
probably used by other tools in the Linux Kconfig toolchain. But as a results
the file created by Dumpconf is not "xml" compliant by default and the XML parser will crash. 

_If you forgot to do this, this is what will happen:
 
[Fatal Error] old_fm<some big number>.fm:2:1: Content is not allowed in prolog. _

And recompile ;)

This is important: you are building the Kconfig parser we will use
with the modified code, against a given Linux repo. 
As the Kconfig language evolved, you *may*  need to recompile the parser against the newer/older version of the parser. 
Checkout the appropriate revision of the Linux kernel in your linux git repo, run "make menuconfig" to update the object files required
and _only then_ re-compile dumpconf.