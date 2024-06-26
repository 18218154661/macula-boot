/*
 * Copyright (c) 2024 Macula
 *   macula.dev, China
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.macula.boot.starter.task.config;

import dev.macula.boot.starter.task.config.powerjob.PowerJobConfiguration;
import dev.macula.boot.starter.task.config.xxljob.XxlJobConfiguration;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

/**
 * {@code TaskAutoConfiguration} 定时任务自动配置
 *
 * @author rain
 * @since 2023/7/4 19:28
 */
@AutoConfiguration
@EnableConfigurationProperties(TaskProperties.class)
@Import({XxlJobConfiguration.class, PowerJobConfiguration.class})
public class TaskAutoConfiguration {
}
