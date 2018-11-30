/*
 * Copyright 2012 LinkedIn Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.mlamp.cotto.sender.mail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class DefaultMailCreator implements MailCreator {

    public static final String DEFAULT_MAIL_CREATOR = "default";
    private static final DateFormat DATE_FORMATTER = new SimpleDateFormat(
            "yyyy/MM/dd HH:mm:ss z");
    private static final HashMap<String, MailCreator> registeredCreators = new HashMap<>();
    private static final MailCreator defaultCreator;

    static {
        defaultCreator = new DefaultMailCreator();
        registerCreator(DEFAULT_MAIL_CREATOR, defaultCreator);
    }

    public static void registerCreator(final String name, final MailCreator creator) {
        registeredCreators.put(name, creator);
    }

    public static MailCreator getCreator(final String name) {
        MailCreator creator = registeredCreators.get(name);
        if (creator == null) {
            creator = defaultCreator;
        }
        return creator;
    }

    private static String convertMSToString(final long timeInMS) {
        if (timeInMS < 0) {
            return "N/A";
        } else {
            return DATE_FORMATTER.format(new Date(timeInMS));
        }
    }

    @Override
    public boolean createFirstErrorMessage(Object flow, EmailMessage message, String azkabanName, String scheme, String clientHostname, String clientPortNumber) {
        //final ExecutionOptions option = flow.getExecutionOptions();
        final List<String> emailList = new ArrayList<String>();
        //final int execId = flow.getExecutionId();

        if (emailList != null && !emailList.isEmpty()) {
            message.addAllToAddress(emailList);
            message.setMimeType("text/html");
            message.setSubject("Flow '" + "test" + "' has encountered a failure on "
                    + azkabanName);

            message.println("<h2 style=\"color:#FF0000\"> Execution '"
                    + "test" + "' of flow '" + "placeholder" + "' of project '"
                    + "placeholder" + "' has encountered a failure on " + azkabanName + "</h2>");

            message.println("<table>");
            message.println("<tr><td>Start Time</td><td>"
                    + "</td></tr>");
            message.println("<tr><td>End Time</td><td>"
                    + "</td></tr>");
            message.println("<tr><td>Duration</td><td>"
                    + "</td></tr>");
            message.println("<tr><td>Status</td><td>" + "placeholder" + "</td></tr>");
            message.println("</table>");
            message.println("");
            final String executionUrl =
                    scheme + "://" + clientHostname + ":" + clientPortNumber + "/"
                            + "executor?" + "execid=" + "placeholder";
            message.println("<a href=\"" + executionUrl + "\">" + "placeholder"
                    + " Execution Link</a>");

            message.println("");
            message.println("<h3>Reason</h3>");
            final List<String> failedJobs = new ArrayList<String>();
            message.println("<ul>");
            for (final String jobId : failedJobs) {
                message.println("<li><a href=\"" + executionUrl + "&job=" + jobId
                        + "\">Failed job '" + jobId + "' Link</a></li>");
            }

            message.println("</ul>");
            return true;
        }
        return false;
    }

    @Override
    public boolean createErrorEmail(Object flow, List<Object> pastExecutions, EmailMessage message, String azkabanName, String scheme, String clientHostname, String clientPortNumber, String... reasons) {
        //final ExecutionOptions option = flow.getExecutionOptions();
        final List<String> emailList = new ArrayList<String>();
        //final int execId = flow.getExecutionId();

        if (emailList != null && !emailList.isEmpty()) {
            message.addAllToAddress(emailList);
            message.setMimeType("text/html");
            message.setSubject("Flow '" + "test" + "' has encountered a failure on "
                    + azkabanName);

            message.println("<h2 style=\"color:#FF0000\"> Execution '"
                    + "test" + "' of flow '" + "placeholder" + "' of project '"
                    + "placeholder" + "' has encountered a failure on " + azkabanName + "</h2>");

            message.println("<table>");
            message.println("<tr><td>Start Time</td><td>"
                    + "</td></tr>");
            message.println("<tr><td>End Time</td><td>"
                    + "</td></tr>");
            message.println("<tr><td>Duration</td><td>"
                    + "</td></tr>");
            message.println("<tr><td>Status</td><td>" + "placeholder" + "</td></tr>");
            message.println("</table>");
            message.println("");
            final String executionUrl =
                    scheme + "://" + clientHostname + ":" + clientPortNumber + "/"
                            + "executor?" + "execid=" + "placeholder";
            message.println("<a href=\"" + executionUrl + "\">" + "placeholder"
                    + " Execution Link</a>");

            message.println("");
            message.println("<h3>Reason</h3>");
            final List<String> failedJobs = new ArrayList<String>();
            message.println("<ul>");
            for (final String jobId : failedJobs) {
                message.println("<li><a href=\"" + executionUrl + "&job=" + jobId
                        + "\">Failed job '" + jobId + "' Link</a></li>");
            }

            message.println("</ul>");
            return true;
        }
        return false;
    }

    @Override
    public boolean createSuccessEmail(Object flow, EmailMessage message, String azkabanName, String scheme, String clientHostname, String clientPortNumber) {
        //final ExecutionOptions option = flow.getExecutionOptions();
        final List<String> emailList = new ArrayList<String>();
        //final int execId = flow.getExecutionId();

        if (emailList != null && !emailList.isEmpty()) {
            message.addAllToAddress(emailList);
            message.setMimeType("text/html");
            message.setSubject("Flow '" + "test" + "' has encountered a failure on "
                    + azkabanName);

            message.println("<h2 style=\"color:#FF0000\"> Execution '"
                    + "test" + "' of flow '" + "placeholder" + "' of project '"
                    + "placeholder" + "' has encountered a failure on " + azkabanName + "</h2>");

            message.println("<table>");
            message.println("<tr><td>Start Time</td><td>"
                    + "</td></tr>");
            message.println("<tr><td>End Time</td><td>"
                    + "</td></tr>");
            message.println("<tr><td>Duration</td><td>"
                    + "</td></tr>");
            message.println("<tr><td>Status</td><td>" + "placeholder" + "</td></tr>");
            message.println("</table>");
            message.println("");
            final String executionUrl =
                    scheme + "://" + clientHostname + ":" + clientPortNumber + "/"
                            + "executor?" + "execid=" + "placeholder";
            message.println("<a href=\"" + executionUrl + "\">" + "placeholder"
                    + " Execution Link</a>");

            message.println("");
            message.println("<h3>Reason</h3>");
            final List<String> failedJobs = new ArrayList<String>();
            message.println("<ul>");
            for (final String jobId : failedJobs) {
                message.println("<li><a href=\"" + executionUrl + "&job=" + jobId
                        + "\">Failed job '" + jobId + "' Link</a></li>");
            }

            message.println("</ul>");
            return true;
        }
        return false;
    }

    @Override
    public boolean createFailedUpdateMessage(List<Object> flows, Object executor, Object updateException, EmailMessage message, String azkabanName, String scheme, String clientHostname, String clientPortNumber) {
        //final ExecutionOptions option = flow.getExecutionOptions();
        final List<String> emailList = new ArrayList<String>();
        //final int execId = flow.getExecutionId();

        if (emailList != null && !emailList.isEmpty()) {
            message.addAllToAddress(emailList);
            message.setMimeType("text/html");
            message.setSubject("Flow '" + "test" + "' has encountered a failure on "
                    + azkabanName);

            message.println("<h2 style=\"color:#FF0000\"> Execution '"
                    + "test" + "' of flow '" + "placeholder" + "' of project '"
                    + "placeholder" + "' has encountered a failure on " + azkabanName + "</h2>");

            message.println("<table>");
            message.println("<tr><td>Start Time</td><td>"
                    + "</td></tr>");
            message.println("<tr><td>End Time</td><td>"
                    + "</td></tr>");
            message.println("<tr><td>Duration</td><td>"
                    + "</td></tr>");
            message.println("<tr><td>Status</td><td>" + "placeholder" + "</td></tr>");
            message.println("</table>");
            message.println("");
            final String executionUrl =
                    scheme + "://" + clientHostname + ":" + clientPortNumber + "/"
                            + "executor?" + "execid=" + "placeholder";
            message.println("<a href=\"" + executionUrl + "\">" + "placeholder"
                    + " Execution Link</a>");

            message.println("");
            message.println("<h3>Reason</h3>");
            final List<String> failedJobs = new ArrayList<String>();
            message.println("<ul>");
            for (final String jobId : failedJobs) {
                message.println("<li><a href=\"" + executionUrl + "&job=" + jobId
                        + "\">Failed job '" + jobId + "' Link</a></li>");
            }

            message.println("</ul>");
            return true;
        }
        return false;
    }

}
