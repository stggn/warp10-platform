//
//   Copyright 2020  SenX S.A.S.
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.
//

package io.warp10.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.apache.commons.math3.linear.RealVector;

import java.io.IOException;

public class RealVectorSerializer extends StdSerializer<RealVector> {

  protected RealVectorSerializer() {
    super(RealVector.class);
  }

  @Override
  public void serialize(RealVector realVector, JsonGenerator gen, SerializerProvider provider) throws IOException {
    // Can't use realVector.iterator() because of a bug: RealVector.Entry is protected
    double[] entries = realVector.toArray();
    gen.writeArray(entries, 0, entries.length);
  }
}
