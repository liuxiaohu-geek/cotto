package com.mlamp.cotto.hadoop.security;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExecuteAsUser {
    private final static Logger log = Logger.getLogger(ExecuteAsUser.class);
    private final static String EXECUTE_AS_USER = "execute-as-user";

    private final File binaryExecutable;

    /**
     * Construct the object
     *
     * @param nativeLibDirectory Absolute path to the native Lib Directory
     */
    public ExecuteAsUser(final String nativeLibDirectory) {
        this.binaryExecutable = new File(nativeLibDirectory, EXECUTE_AS_USER);
        validate();
    }

    private void validate() {
        if (!this.binaryExecutable.canExecute()) {
            throw new RuntimeException("Unable to execute execute-as-user binary. Invalid Path: "
                    + this.binaryExecutable.getAbsolutePath());
        }
    }

    /**
     * API to execute a command on behalf of another user.
     *
     * @param user    The proxy user
     * @param command the list containing the program and its arguments
     * @return The return value of the shell command
     */
    public int execute(final String user, final List<String> command) throws IOException {
        log.info("Command: " + command);
        final Process process = new ProcessBuilder()
                .command(constructExecuteAsCommand(user, command))
                .inheritIO()
                .start();

        int exitCode;
        try {
            exitCode = process.waitFor();
        } catch (final InterruptedException e) {
            log.error(e.getMessage(), e);
            exitCode = 1;
        }
        return exitCode;
    }

    private List<String> constructExecuteAsCommand(final String user, final List<String> command) {
        final List<String> commandList = new ArrayList<>();
        commandList.add(this.binaryExecutable.getAbsolutePath());
        commandList.add(user);
        commandList.addAll(command);
        return commandList;
    }
}
