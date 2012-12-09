package sample.play.jbehave.spring.service.math.spec;

import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.UsingSteps;
import org.jbehave.core.annotations.spring.UsingSpring;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.junit.spring.SpringAnnotatedEmbedderRunner;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.junit.runner.RunWith;

import java.net.MalformedURLException;
import java.net.URL;

@RunWith(SpringAnnotatedEmbedderRunner.class)
@UsingSpring(resources = "application-context.xml")
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = true, ignoreFailureInView = false,
        stepsFactory = true)
@UsingSteps
public class MathFeature extends JUnitStory {
    // Here we specify the configuration, starting from default MostUsefulConfiguration, and changing only what is needed
    @Override
    public Configuration configuration() {
        // where to find the stories
        URL storyURL = null;
        try {
            storyURL = new URL("file://" + System.getProperty("user.dir") + "/test");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return new MostUsefulConfiguration()
                .useStoryLoader(storyURL != null ? new LoadFromRelativeFile(storyURL) : new LoadFromClasspath(this.getClass()))
                        // CONSOLE and TXT reporting
                .useStoryReporterBuilder(new StoryReporterBuilder().withDefaultFormats().withFormats(Format.CONSOLE, Format.TXT));
    }
}