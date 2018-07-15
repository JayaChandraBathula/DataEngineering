The program is written in Java programming Language.
Each Line of the input file is read using FileReader function in Java.
The first name and last name are combined during the read time.
An class is created for the Medicine name, prescriber name and the cost and later the values are used by instantiating the class.
Later validations for the medicine names are done by consuming the objects which are created earlier.
For each medicine the cost is incremented by += operator using for loop for each record of the medicine.
All the prescriber names are added to an array list and is checked if the list contains any duplicate values.
If the array list doesn’t contain any duplicate values, then the count is incremented by one.
Finally, the obtained output is written to the text file using PrintWriter function.

I have tested the code with several test input files and it is working fine.
I am placing a sample test file in the input folder which is being tested. The generated output file is in the output folder.

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

The above mentioned import are few basic import for the java files provided.
