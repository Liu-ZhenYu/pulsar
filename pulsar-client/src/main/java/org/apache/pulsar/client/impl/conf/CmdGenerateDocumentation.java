/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.pulsar.client.impl.conf;

import com.beust.jcommander.Parameters;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.broker.BaseGenerateDocumentation;

@Data
@Parameters(commandDescription = "Generate documentation automatically.")
@Slf4j
public class CmdGenerateDocumentation extends BaseGenerateDocumentation {

    @Override
    public String generateDocumentByClassName(String className) throws Exception {
        StringBuilder sb = new StringBuilder();
        if (ClientConfigurationData.class.getName().equals(className)) {
            return generateDocByApiModelProperty(className, "Client", sb);
        } else if (ProducerConfigurationData.class.getName().equals(className)) {
            return generateDocByApiModelProperty(className, "Producer", sb);
        } else if (ConsumerConfigurationData.class.getName().equals(className)) {
            return generateDocByApiModelProperty(className, "Consumer", sb);
        } else if (ReaderConfigurationData.class.getName().equals(className)) {
            return generateDocByApiModelProperty(className, "Reader", sb);
        }

        return "Class [" + className + "] not found";
    }

    public static void main(String[] args) throws Exception {
        CmdGenerateDocumentation generateDocumentation = new CmdGenerateDocumentation();
        generateDocumentation.run(args);
    }
}
