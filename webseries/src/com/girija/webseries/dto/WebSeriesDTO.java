package com.girija.webseries.dto;

import java.io.Serializable;

import com.girija.webseries.constant.GenreType;
import com.girija.webseries.constant.StreamedIN;

public class WebSeriesDTO implements Serializable {
private int id;
private String webName;
private int noOfEpisodes;
private int  totalSeasons;
private int yestAgeIndNodBahudu;
private StreamedIN streaming;
private GenreType webType;
public WebSeriesDTO() {

}
public WebSeriesDTO(int id, String webName, int noOfEpisodes, int totalSeasons, int yestAgeIndNodBahudu,
		StreamedIN streaming, GenreType webType) {
	super();
	this.id = id;
	this.webName = webName;
	this.noOfEpisodes = noOfEpisodes;
	this.totalSeasons = totalSeasons;
	this.yestAgeIndNodBahudu = yestAgeIndNodBahudu;
	this.streaming = streaming;
	this.webType = webType;
}

public WebSeriesDTO(String webName, int noOfEpisodes, int totalSeasons, int yestAgeIndNodBahudu, StreamedIN streaming,
		GenreType webType) {
	super();
	this.webName = webName;
	this.noOfEpisodes = noOfEpisodes;
	this.totalSeasons = totalSeasons;
	this.yestAgeIndNodBahudu = yestAgeIndNodBahudu;
	this.streaming = streaming;
	this.webType = webType;
}
@Override
public String toString() {
	return "WebSeriesDTO [id=" + id + ", webName=" + webName + ", noOfEpisodes=" + noOfEpisodes + ", totalSeasons="
			+ totalSeasons + ", yestAgeIndNodBahudu=" + yestAgeIndNodBahudu + ", streaming=" + streaming + ", webType="
			+ webType + "]";
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
	result = prime * result + noOfEpisodes;
	result = prime * result + ((streaming == null) ? 0 : streaming.hashCode());
	result = prime * result + totalSeasons;
	result = prime * result + ((webName == null) ? 0 : webName.hashCode());
	result = prime * result + ((webType == null) ? 0 : webType.hashCode());
	result = prime * result + yestAgeIndNodBahudu;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	WebSeriesDTO other = (WebSeriesDTO) obj;
	if (id != other.id)
		return false;
	if (noOfEpisodes != other.noOfEpisodes)
		return false;
	if (streaming != other.streaming)
		return false;
	if (totalSeasons != other.totalSeasons)
		return false;
	if (webName == null) {
		if (other.webName != null)
			return false;
	} else if (!webName.equals(other.webName))
		return false;
	if (webType != other.webType)
		return false;
	if (yestAgeIndNodBahudu != other.yestAgeIndNodBahudu)
		return false;
	return true;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getWebName() {
	return webName;
}
public void setWebName(String webName) {
	this.webName = webName;
}
public int getNoOfEpisodes() {
	return noOfEpisodes;
}
public void setNoOfEpisodes(int noOfEpisodes) {
	this.noOfEpisodes = noOfEpisodes;
}
public int getTotalSeasons() {
	return totalSeasons;
}
public void setTotalSeasons(int totalSeasons) {
	this.totalSeasons = totalSeasons;
}
public int getYestAgeIndNodBahudu() {
	return yestAgeIndNodBahudu;
}
public void setYestAgeIndNodBahudu(int yestAgeIndNodBahudu) {
	this.yestAgeIndNodBahudu = yestAgeIndNodBahudu;
}
public StreamedIN getStreaming() {
	return streaming;
}
public void setStreaming(StreamedIN streaming) {
	this.streaming = streaming;
}
public GenreType getWebType() {
	return webType;
}
public void setWebType(GenreType webType) {
	this.webType = webType;
}

}