package practicechoiceformat;

import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.text.ParsePosition;

/**
 *
 * @author santiago
 */
public class PracticeChoiceFormat {
//el cambio
    public static void exampleComplex() {
        double[] filelimits = {0, 1, 2};
        String[] filepart = {"are no files", "is one file", "are {2} files"};
        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
        Format[] testFormats = {fileform, null, NumberFormat.getInstance()};
        MessageFormat pattform = new MessageFormat("There {0} on {1}");
        pattform.setFormats(testFormats);
        Object[] testArgs = {null, "ADisk", null};
        for (int i = 0; i < 4; ++i) {
            testArgs[0] = new Integer(i);
            testArgs[2] = testArgs[0];
            System.out.println(pattform.format(testArgs));
        }
    }

    public static void exampleSimplex() {
        double[] filelimits = {0, 1, 2};
        double[] limits = {1, 2, 3, 4, 5, 6, 7};
        String[] dayOfWeekNames = {"Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"};
        ChoiceFormat form = new ChoiceFormat(limits, dayOfWeekNames);
        ParsePosition status = new ParsePosition(0);
        for (double i = 0.0; i <= 8.0; ++i) {
            status.setIndex(0);
            System.out.println(i + " -> " + form.format(i) + " -> "
                    + form.parse(form.format(i), status));
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PracticeChoiceFormat.exampleComplex();
    }

}
