/*
 * Copyright (c) 2015-present, Facebook, Inc.
 *
 * This source code is licensed under the MIT license found in the
 * LICENSE file in the root directory of this source tree.
 */
package com.facebook.animated.giflite.decoder;

import android.graphics.Movie;
import com.facebook.imagepipeline.animated.base.AnimatedDrawableFrameInfo;
import java.io.IOException;
import java.io.InputStream;

public interface GifMetadataDecoder {

  void decode() throws IOException;

  int getFrameCount();

  int getLoopCount();

  AnimatedDrawableFrameInfo.DisposalMethod getFrameDisposal(int frameNumber);

  int getFrameDurationMs(int frameNumber);

  class Factory {
    public static GifMetadataDecoder create(Movie movie) throws IOException {
      GifMetadataDecoder decoder = new GifSimpleMetadataDecoder(movie);
      decoder.decode();
      return decoder;
    }
  }
}
