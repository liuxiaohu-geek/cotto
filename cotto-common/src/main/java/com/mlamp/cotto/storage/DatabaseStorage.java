/*
 * Copyright 2017 LinkedIn Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 *
 */

package com.mlamp.cotto.storage;

import com.mlamp.cotto.spi.Storage;
import com.mlamp.cotto.spi.StorageMetadata;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.File;
import java.io.InputStream;


/**
 * DatabaseStorage
 * <p>
 * This class helps in storing projects in the DB itself. This is intended to be the default since
 * it is the current behavior of Azkaban.
 */
@Singleton
public class DatabaseStorage implements Storage {

    private final Object projectLoader;

    @Inject
    public DatabaseStorage(final Object projectLoader) {
        this.projectLoader = projectLoader;
    }

    @Override
    public InputStream get(final String key) {
        throw new UnsupportedOperationException(
                "Not implemented yet. Use get(projectId, version) instead");
    }

    public Object get(final int projectId, final int version) {
        //return this.projectLoader.getUploadedFile(projectId, version);
        return new Object();
    }

    @Override
    public String put(final StorageMetadata metadata, final File localFile) {
        //TODO
        return null;
    }

    @Override
    public boolean delete(final String key) {
        throw new UnsupportedOperationException("Delete is not supported");
    }
}
