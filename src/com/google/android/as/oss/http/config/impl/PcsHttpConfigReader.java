/*
 * Copyright 2021 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.android.as.oss.http.config.impl;

import com.google.android.as.oss.common.config.AbstractConfigReader;
import com.google.android.as.oss.common.config.FlagListener;
import com.google.android.as.oss.common.config.FlagManager;
import com.google.android.as.oss.common.config.FlagManager.BooleanFlag;
import com.google.android.as.oss.http.config.PcsHttpConfig;

/** ConfigReader for {@link PcsHttpConfig}. */
class PcsHttpConfigReader extends AbstractConfigReader<PcsHttpConfig> {
  private static final String FLAG_PREFIX = "PcsHttp__";

  static final BooleanFlag ENABLE_ON_READY_HANDLER =
      BooleanFlag.create("PcsHttp__enable_on_ready_handler", false);

  private final FlagManager flagManager;

  static PcsHttpConfigReader create(FlagManager flagManager) {
    PcsHttpConfigReader instance = new PcsHttpConfigReader(flagManager);

    instance
        .flagManager
        .listenable()
        .addListener(
            (flagNames) -> {
              if (FlagListener.anyHasPrefix(flagNames, FLAG_PREFIX)) {
                instance.refreshConfig();
              }
            });

    return instance;
  }

  @Override
  protected PcsHttpConfig computeConfig() {
    return PcsHttpConfig.builder()
        .setOnReadyHandlerEnabled(flagManager.get(ENABLE_ON_READY_HANDLER))
        .build();
  }

  private PcsHttpConfigReader(FlagManager flagManager) {
    this.flagManager = flagManager;
  }
}