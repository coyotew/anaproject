import eu.fbk.dh.tint.runner.TintPipeline;
import edu.stanford.nlp.pipeline.Annotation;
import eu.fbk.dh.tint.runner.TintRunner;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LinguisticAnalysis {

    public static void main(String [] args) {

        try {
            TintPipeline pipeline = new TintPipeline();
            pipeline.loadDefaultProperties();
            pipeline.load();
            String text = "I topi non avevano nipoti.";
            // Get the original Annotation (Stanford CoreNLP)
            //Annotation stanfordAnnotation = pipeline.runRaw(text);
            //System.out.println("*** " + stanfordAnnotation.toString());
            InputStream stream = new ByteArrayInputStream(text.getBytes("UTF-8"));
            Annotation annotation = pipeline.run(stream, System.out, TintRunner.OutputFormat.JSON);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
