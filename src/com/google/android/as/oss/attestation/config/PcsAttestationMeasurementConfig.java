/*
 * Copyright 2023 Google LLC
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

package com.google.android.as.oss.attestation.config;

import com.google.auto.value.AutoValue;

/** Config that contains Pcs Attestation flags. */
@AutoValue
public abstract class PcsAttestationMeasurementConfig {

  public static Builder builder() {
    return new AutoValue_PcsAttestationMeasurementConfig.Builder()
        .setEnableAttestationMeasurement(false);
  }

  public abstract boolean enableAttestationMeasurement();

  /** Builder for {@link PcsAttestationMeasurementConfig}. */
  @AutoValue.Builder
  public abstract static class Builder {
    public abstract Builder setEnableAttestationMeasurement(boolean value);

    public abstract PcsAttestationMeasurementConfig build();
  }
}