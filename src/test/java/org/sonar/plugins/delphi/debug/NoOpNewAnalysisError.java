package org.sonar.plugins.delphi.debug;

import org.sonar.api.batch.fs.InputFile;
import org.sonar.api.batch.fs.TextPointer;
import org.sonar.api.batch.sensor.error.NewAnalysisError;

/**
 * Created by humphreysm on 21/07/2017.
 */
public class NoOpNewAnalysisError implements NewAnalysisError {
    @Override
    public NewAnalysisError onFile(InputFile inputFile) {
        // no op
        return this;
    }

    @Override
    public NewAnalysisError message(String message) {
        // no op
        return this;
    }

    @Override
    public NewAnalysisError at(TextPointer textPointer) {
        return null;
    }

    @Override
    public void save() {
        // no op
    }

}
