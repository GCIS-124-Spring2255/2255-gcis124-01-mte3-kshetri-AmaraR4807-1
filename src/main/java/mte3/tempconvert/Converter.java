// Exam: 2255 GCIS 124, Mid Term Exam #3, Question 1
// Filename: Converter.java (inside tempconvert package)

package mte3.tempconvert;
import java.util.Scanner;

public class Converter {
    
    private static class CelsiusToFahrenheit implements TempConvert {

        @Override
        public double convert(double temp) {    return temp * 9.0 / 5.0 + 32;    }
        
    } // CelciusToFahrenheit closed

    public static void main(String[] args) {
        
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please enter temperature (for conversion): ");
            double ImputTemp = scanner.nextDouble(); 
            
            // (part 1) conversion from C to F
            CelsiusToFahrenheit CTF = new CelsiusToFahrenheit();
            double fahrinheit = CTF.convert(ImputTemp);
            
            // (part 2) conversion from F to C // using an Anonymous class
            TempConvert FTC = new TempConvert() {
                @Override
                public double convert(double temp) {
                    return (temp - 32) * 5 / 9;
                }
            };
            double celsius = FTC.convert(ImputTemp);
            
            // (part 3) conversion from F to K // using lambda
            TempConvert FTK = (temp) -> (temp - 32) * 5 / 9 + 273.15;
            double kelvin = FTK.convert(ImputTemp);

            System.out.printf("C to F: %.3f, F to C: %.3f, F to K: %.3f%n", fahrinheit, celsius, kelvin);
        }  // try { } block closed

    } // main () method closed

} // Converter { } class closed