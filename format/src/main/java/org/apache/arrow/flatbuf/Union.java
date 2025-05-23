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

import com.google.flatbuffers.BaseVector;
import com.google.flatbuffers.BooleanVector;
import com.google.flatbuffers.ByteVector;
import com.google.flatbuffers.Constants;
import com.google.flatbuffers.DoubleVector;
import com.google.flatbuffers.FlatBufferBuilder;
import com.google.flatbuffers.FloatVector;
import com.google.flatbuffers.IntVector;
import com.google.flatbuffers.LongVector;
import com.google.flatbuffers.ShortVector;
import com.google.flatbuffers.StringVector;
import com.google.flatbuffers.Struct;
import com.google.flatbuffers.Table;
import com.google.flatbuffers.UnionVector;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * A union is a complex type with children in Field
 * By default ids in the type vector refer to the offsets in the children
 * optionally typeIds provides an indirection between the child offset and the type id
 * for each child `typeIds[offset]` is the id used in the type vector
 */
@SuppressWarnings("unused")
public final class Union extends Table {
  public static void ValidateVersion() { Constants.FLATBUFFERS_25_2_10(); }
  public static Union getRootAsUnion(ByteBuffer _bb) { return getRootAsUnion(_bb, new Union()); }
  public static Union getRootAsUnion(ByteBuffer _bb, Union obj) { _bb.order(ByteOrder.LITTLE_ENDIAN); return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb)); }
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public Union __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public short mode() { int o = __offset(4); return o != 0 ? bb.getShort(o + bb_pos) : 0; }
  public int typeIds(int j) { int o = __offset(6); return o != 0 ? bb.getInt(__vector(o) + j * 4) : 0; }
  public int typeIdsLength() { int o = __offset(6); return o != 0 ? __vector_len(o) : 0; }
  public IntVector typeIdsVector() { return typeIdsVector(new IntVector()); }
  public IntVector typeIdsVector(IntVector obj) { int o = __offset(6); return o != 0 ? obj.__assign(__vector(o), bb) : null; }
  public ByteBuffer typeIdsAsByteBuffer() { return __vector_as_bytebuffer(6, 4); }
  public ByteBuffer typeIdsInByteBuffer(ByteBuffer _bb) { return __vector_in_bytebuffer(_bb, 6, 4); }

  public static int createUnion(FlatBufferBuilder builder,
      short mode,
      int typeIdsOffset) {
    builder.startTable(2);
    Union.addTypeIds(builder, typeIdsOffset);
    Union.addMode(builder, mode);
    return Union.endUnion(builder);
  }

  public static void startUnion(FlatBufferBuilder builder) { builder.startTable(2); }
  public static void addMode(FlatBufferBuilder builder, short mode) { builder.addShort(0, mode, 0); }
  public static void addTypeIds(FlatBufferBuilder builder, int typeIdsOffset) { builder.addOffset(1, typeIdsOffset, 0); }
  public static int createTypeIdsVector(FlatBufferBuilder builder, int[] data) { builder.startVector(4, data.length, 4); for (int i = data.length - 1; i >= 0; i--) builder.addInt(data[i]); return builder.endVector(); }
  public static void startTypeIdsVector(FlatBufferBuilder builder, int numElems) { builder.startVector(4, numElems, 4); }
  public static int endUnion(FlatBufferBuilder builder) {
    int o = builder.endTable();
    return o;
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public Union get(int j) { return get(new Union(), j); }
    public Union get(Union obj, int j) {  return obj.__assign(__indirect(__element(j), bb), bb); }
  }
}
