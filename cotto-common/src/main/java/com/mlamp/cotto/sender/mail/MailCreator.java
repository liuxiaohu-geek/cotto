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

import java.util.List;

public interface MailCreator {

    boolean createFirstErrorMessage(Object flow,
                                    EmailMessage message, String azkabanName, String scheme,
                                    String clientHostname, String clientPortNumber);

    boolean createErrorEmail(Object flow, List<Object> pastExecutions,
                             EmailMessage message, String azkabanName, String scheme, String clientHostname,
                             String clientPortNumber, String... reasons);

    boolean createSuccessEmail(Object flow, EmailMessage message,
                               String azkabanName, String scheme, String clientHostname,
                               String clientPortNumber);

    boolean createFailedUpdateMessage(List<Object> flows, Object executor,
                                      Object updateException, EmailMessage message,
                                      String azkabanName, String scheme, String clientHostname,
                                      String clientPortNumber);
}