package com.test.ws;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"title",
"episode_id",
"opening_crawl",
"director",
"producer",
"release_date",
"characters",
"planets",
"starships",
"vehicles",
"species",
"created",
"edited",
"url"
})
public class Result {

@JsonProperty("title")
private String title;
@JsonProperty("episode_id")
private Integer episodeId;
@JsonProperty("opening_crawl")
private String openingCrawl;
@JsonProperty("director")
private String director;
@JsonProperty("producer")
private String producer;

@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("title")
public String getTitle() {
return title;
}

@JsonProperty("title")
public void setTitle(String title) {
this.title = title;
}

@JsonProperty("director")
public String getDirector() {
return director;
}

@JsonProperty("director")
public void setDirector(String director) {
this.director = director;
}

@JsonProperty("producer")
public String getProducer() {
return producer;
}

@JsonProperty("producer")
public void setProducer(String producer) {
this.producer = producer;
}

@JsonAnyGetter
public Map<String, Object> getAdditionalProperties() {
return this.additionalProperties;
}

@JsonAnySetter
public void setAdditionalProperty(String name, Object value) {
this.additionalProperties.put(name, value);
}

}