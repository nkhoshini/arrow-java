/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.arrow.flatbuf;

@SuppressWarnings("unused")
public final class MetadataVersion {
  private MetadataVersion() { }
  /**
   * 0.1.0 (October 2016).
   */
  public static final short V1 = 0;
  /**
   * 0.2.0 (February 2017). Non-backwards compatible with V1.
   */
  public static final short V2 = 1;
  /**
   * 0.3.0 -> 0.7.1 (May - December 2017). Non-backwards compatible with V2.
   */
  public static final short V3 = 2;
  /**
   * >= 0.8.0 (December 2017). Non-backwards compatible with V3.
   */
  public static final short V4 = 3;
  /**
   * >= 1.0.0 (July 2020). Backwards compatible with V4 (V5 readers can read V4
   * metadata and IPC messages). Implementations are recommended to provide a
   * V4 compatibility mode with V5 format changes disabled.
   *
   * Incompatible changes between V4 and V5:
   * - Union buffer layout has changed. In V5, Unions don't have a validity
   *   bitmap buffer.
   */
  public static final short V5 = 4;

  public static final String[] names = { "V1", "V2", "V3", "V4", "V5", };

  public static String name(int e) { return names[e]; }
}
