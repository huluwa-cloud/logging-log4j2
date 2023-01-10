/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache license, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the license for the specific language governing permissions and
 * limitations under the license.
 */
package org.apache.logging.log4j.internal;

/**
 * Keeps track of LogManager initialization status;
 *
 * 看代码的时候，发现，专门建了一个类来处理LogManager的状态。觉得有点鸡肋。
 * 果然，这个类是2020年12月11日才加上去的。
 * 是为了处理跟spring-boot的集成问题
 *
 */
public class LogManagerStatus {

    private static boolean initialized = false;

    public static void setInitialized(boolean managerStatus) {
        initialized = managerStatus;
    }

    public static boolean isInitialized() {
        return initialized;
    }
}
