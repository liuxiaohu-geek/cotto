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

package com.mlamp.cotto.metric;

/**
 * Interface of any Metric
 *
 * @param <T> Type of Value of a given metric
 */
public interface IMetric<T> {

    String getName();

    String getValueType();

    void updateMetricManager(final MetricReportManager manager);

    void notifyManager();

    T getValue();

    IMetric<T> getSnapshot() throws CloneNotSupportedException;
}
