GH4RawConverter
===============

Converts Raw Files of GH4 Camera to be viewable in Adobe Lightroom.

The GH4 Raw files contain the model string "Panasonic-GH4" which makes it currently not viewable in Adobe Lightroom. Changing the Model name to "Panasonic-GH3" makes the file viewable. Thus, the converter changes the byte on position 890, which contains the number "4" to the number "3".

#Usage

###Prerequisites
1. You need to have a JRE 7 installed on your local computer.
2. Make **a copy** of the Raw files you want to view in Light Room. This is needed as a backup, as you're performing binary changes on the files. Additionally you may want to use the innate capability of lightroom to open GH4 raw files once it is released.

###Execution

Two possibilities:

First:
1. Copy the executable jar to the directory in which your Raw files are located.
2. Double-click the jar file to execute. This converts all .RW2 files in the current directory.

Second:
1. Open a terminal in the directory where the .jar file is located.
2. Execute the .jar file with the path to the Raw files as a parameter, e.g.:

    `java -jar RawConverter.jar /path/to/your/rawfiles/`


#Download
[Converter as .jar](https://github.com/jsosulski/GH4RawConverter/blob/master/RawConverter.jar?raw=true)

#Additional information
This converter is meant as a temporary workaround to view the Raw files produced by the GH4. Do not use this converter after Lightroom provides inherent support for the GH4 Raw files. The converter is published under the MIT license.