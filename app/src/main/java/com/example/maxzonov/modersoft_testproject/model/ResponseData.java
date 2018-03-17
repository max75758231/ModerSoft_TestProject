package com.example.maxzonov.modersoft_testproject.model;


import com.google.gson.annotations.SerializedName;

public class ResponseData {

    @SerializedName("data")
    private Data data;

    @SerializedName("error")
    private Error error;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public class Error {

        @SerializedName("code")
        String code;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
