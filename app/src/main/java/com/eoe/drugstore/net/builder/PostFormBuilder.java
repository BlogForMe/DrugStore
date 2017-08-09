package com.eoe.drugstore.net.builder;

import com.eoe.drugstore.net.request.PostFormRequest;
import com.eoe.drugstore.net.request.RequestCall;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jon on 17-8-9.
 */

public class PostFormBuilder extends OkHttpRequestBuilder<PostFormBuilder> {

    private List<FileInput> files = new ArrayList<>();

    @Override

    public RequestCall build() {
        return new PostFormRequest(url, tag, params, headers, files, id).build();
    }


    public static class FileInput {
        public String key;
        public String filename;
        public String file;

        public FileInput(String key, String filename, String file) {
            this.key = key;
            this.filename = filename;
            this.file = file;
        }

        @Override
        public String toString() {
            return "FileInput{" +
                    "key='" + key + '\'' +
                    ", filename='" + filename + '\'' +
                    ", file='" + file + '\'' +
                    '}';
        }
    }
}
