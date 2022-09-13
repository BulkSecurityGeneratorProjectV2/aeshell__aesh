/*
 * JBoss, Home of Professional Open Source
 * Copyright 2014 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 * See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.aesh.command.shell;

import org.aesh.readline.Prompt;
import org.aesh.readline.terminal.Key;
import org.aesh.terminal.tty.Size;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:stale.pedersen@jboss.org">Ståle W. Pedersen</a>
 */
public interface Shell {

    /**
     * @param out write out to the output stream
     */
    default void write(String out) {
        write(out, false);
    }

    /**
     * @param out write out to the output stream including a line separator at the end
     */
    default void writeln(String out) {
        writeln(out, false);
    }

    /**
    * Print a message on console
    * @param msg
     * @param paging True means that output longer than terminal height should be paused.
    */
    void write(String msg, boolean paging);

    /**
     * Print a new line with a message on console;
     * @param msg
     * @param paging True means that output longer than terminal height should be paused.
     */
    void writeln(String msg, boolean paging);

    /**
     * @param out write out to the output stream
     */
    void write(int[] out);

    /**
     * @param out write out to the output stream
     */
    void write(char out);

    /**
     * Blocking call which will return when user press the "enter" key
     * @return input line
     */
    String readLine() throws InterruptedException;

    /**
     * Blocking call which will return when user press the "enter" key
     *
     * @param prompt display prompt
     * @return input line
     */
    String readLine(Prompt prompt) throws InterruptedException;

    /**
     * Blocking call which will return when user press the "enter" key
     *
     * @param prompt display prompt
     * @return input line
     */
    default String readLine(String prompt) throws InterruptedException {
        return readLine(new Prompt(prompt));
    }

    /**
     * Blocking call that will return after the first key press
     * @return input
     */
    Key read() throws InterruptedException;

    /**
     * Blocking call that will return after the first key press
     * @return input or null if it times out
     * @throws InterruptedException when interrupted
     */
    Key read(long timeout, TimeUnit unit) throws InterruptedException;

    /**
     * Blocking call that will return after the first key press
     * @return input
     */
    Key read(Prompt prompt) throws InterruptedException;

    boolean enableAlternateBuffer();

    boolean enableMainBuffer();

    Size size();

    /**
     * Clear the terminal
     */
    void clear();
}
