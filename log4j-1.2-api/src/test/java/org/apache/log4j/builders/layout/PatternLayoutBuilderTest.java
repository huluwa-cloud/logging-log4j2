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
package org.apache.log4j.builders.layout;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.stream.Stream;

import org.apache.log4j.Layout;
import org.apache.log4j.bridge.LayoutAdapter;
import org.apache.logging.log4j.core.layout.PatternLayout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class PatternLayoutBuilderTest {

    static Stream<Arguments> patterns() {
        return Arrays.asList(
                    Arguments.of("%p", "%v1Level"),
                    Arguments.of("%100p", "%100v1Level"),
                    Arguments.of("%-100p", "%-100v1Level"),
                    Arguments.of("%x", "%ndc"),
                    Arguments.of("%X", "%properties"),
                    Arguments.of("%.20x", "%.20ndc"))
                .stream();
    }

    @ParameterizedTest
    @MethodSource("patterns")
    public void testLevelPatternReplacement(final String v1Pattern, final String v2Pattern) {
        final PatternLayoutBuilder builder = new PatternLayoutBuilder();
        final PatternLayout layout = (PatternLayout) LayoutAdapter.adapt(builder.createLayout(v1Pattern, null));
        assertEquals(v2Pattern, layout.getConversionPattern());
    }
}
