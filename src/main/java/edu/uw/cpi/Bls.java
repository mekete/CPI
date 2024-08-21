
package edu.uw.cpi;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bls {

    public static void main(String[] args) {
        String aaa= "{\n" +
                "  \"status\": \"REQUEST_SUCCEEDED\",\n" +
                "  \"responseTime\": 161,\n" +
                "  \"message\": [\n" +
                "    \n" +
                "  ],\n" +
                "\n" +
                "\n" +
                "\n" +
                "  \"Results\": {\n" +
                "    \"series\": [\n" +
                "      {\n" +
                "        \"seriesID\": \"LAUCN040010000000005\",\n" +
                "        \"data\": [\n" +
                "          {\n" +
                "            \"year\": \"2024\",\n" +
                "            \"period\": \"M06\",\n" +
                "            \"periodName\": \"June\",\n" +
                "            \"latest\": \"true\",\n" +
                "            \"value\": \"16515\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"P\",\n" +
                "                \"text\": \"Preliminary.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2024\",\n" +
                "            \"period\": \"M05\",\n" +
                "            \"periodName\": \"May\",\n" +
                "            \"value\": \"16573\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2024\",\n" +
                "            \"period\": \"M04\",\n" +
                "            \"periodName\": \"April\",\n" +
                "            \"value\": \"16722\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2024\",\n" +
                "            \"period\": \"M03\",\n" +
                "            \"periodName\": \"March\",\n" +
                "            \"value\": \"16894\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2024\",\n" +
                "            \"period\": \"M02\",\n" +
                "            \"periodName\": \"February\",\n" +
                "            \"value\": \"16704\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2024\",\n" +
                "            \"period\": \"M01\",\n" +
                "            \"periodName\": \"January\",\n" +
                "            \"value\": \"16682\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2023\",\n" +
                "            \"period\": \"M13\",\n" +
                "            \"periodName\": \"Annual\",\n" +
                "            \"value\": \"16842\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2023\",\n" +
                "            \"period\": \"M12\",\n" +
                "            \"periodName\": \"December\",\n" +
                "            \"value\": \"16571\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2023\",\n" +
                "            \"period\": \"M11\",\n" +
                "            \"periodName\": \"November\",\n" +
                "            \"value\": \"16757\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2023\",\n" +
                "            \"period\": \"M10\",\n" +
                "            \"periodName\": \"October\",\n" +
                "            \"value\": \"16808\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2023\",\n" +
                "            \"period\": \"M09\",\n" +
                "            \"periodName\": \"September\",\n" +
                "            \"value\": \"16983\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2023\",\n" +
                "            \"period\": \"M08\",\n" +
                "            \"periodName\": \"August\",\n" +
                "            \"value\": \"17374\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2023\",\n" +
                "            \"period\": \"M07\",\n" +
                "            \"periodName\": \"July\",\n" +
                "            \"value\": \"16492\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2023\",\n" +
                "            \"period\": \"M06\",\n" +
                "            \"periodName\": \"June\",\n" +
                "            \"value\": \"16717\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2023\",\n" +
                "            \"period\": \"M05\",\n" +
                "            \"periodName\": \"May\",\n" +
                "            \"value\": \"16871\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2023\",\n" +
                "            \"period\": \"M04\",\n" +
                "            \"periodName\": \"April\",\n" +
                "            \"value\": \"16732\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2023\",\n" +
                "            \"period\": \"M03\",\n" +
                "            \"periodName\": \"March\",\n" +
                "            \"value\": \"17000\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2023\",\n" +
                "            \"period\": \"M02\",\n" +
                "            \"periodName\": \"February\",\n" +
                "            \"value\": \"16836\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2023\",\n" +
                "            \"period\": \"M01\",\n" +
                "            \"periodName\": \"January\",\n" +
                "            \"value\": \"16961\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2022\",\n" +
                "            \"period\": \"M13\",\n" +
                "            \"periodName\": \"Annual\",\n" +
                "            \"value\": \"16938\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2022\",\n" +
                "            \"period\": \"M12\",\n" +
                "            \"periodName\": \"December\",\n" +
                "            \"value\": \"16945\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2022\",\n" +
                "            \"period\": \"M11\",\n" +
                "            \"periodName\": \"November\",\n" +
                "            \"value\": \"16939\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2022\",\n" +
                "            \"period\": \"M10\",\n" +
                "            \"periodName\": \"October\",\n" +
                "            \"value\": \"17000\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2022\",\n" +
                "            \"period\": \"M09\",\n" +
                "            \"periodName\": \"September\",\n" +
                "            \"value\": \"17173\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2022\",\n" +
                "            \"period\": \"M08\",\n" +
                "            \"periodName\": \"August\",\n" +
                "            \"value\": \"17252\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2022\",\n" +
                "            \"period\": \"M07\",\n" +
                "            \"periodName\": \"July\",\n" +
                "            \"value\": \"16219\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2022\",\n" +
                "            \"period\": \"M06\",\n" +
                "            \"periodName\": \"June\",\n" +
                "            \"value\": \"16734\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2022\",\n" +
                "            \"period\": \"M05\",\n" +
                "            \"periodName\": \"May\",\n" +
                "            \"value\": \"16978\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2022\",\n" +
                "            \"period\": \"M04\",\n" +
                "            \"periodName\": \"April\",\n" +
                "            \"value\": \"16821\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2022\",\n" +
                "            \"period\": \"M03\",\n" +
                "            \"periodName\": \"March\",\n" +
                "            \"value\": \"17082\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2022\",\n" +
                "            \"period\": \"M02\",\n" +
                "            \"periodName\": \"February\",\n" +
                "            \"value\": \"17004\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          },\n" +
                "          {\n" +
                "            \"year\": \"2022\",\n" +
                "            \"period\": \"M01\",\n" +
                "            \"periodName\": \"January\",\n" +
                "            \"value\": \"17103\",\n" +
                "            \"footnotes\": [\n" +
                "              {\n" +
                "                \"code\": \"T\",\n" +
                "                \"text\": \"Data were subject to revision on April 19, 2024.\"\n" +
                "              }\n" +
                "            ]\n" +
                "          }\n" +
                "        ]\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "}";


        Gson gson = new Gson();

        Bls datas
                = gson.fromJson(aaa,
                Bls.class);

        System.out.println(datas.getResults().get(0).getSeries().get(0).getData().get(0).getPeriod());
    }

    //  Results.series.data
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("responseTime")
    @Expose
    private Integer responseTime;
    @SerializedName("message")
    @Expose
    private List<Object> message;
    @SerializedName("Results")
    @Expose
    private List<Result> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Integer responseTime) {
        this.responseTime = responseTime;
    }

    public List<Object> getMessage() {
        return message;
    }

    public void setMessage(List<Object> message) {
        this.message = message;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
