package com.journal;

public class Journal {
	
	private String title;
	private String journal;
	private String issn;
	private String eissn;
	private int year;
	private int month;
	private int valume;
	private int issue;
	private String doi;
	private int pageStart;
	private int pageEnd;
	private String authors;
	private String affiliations;
	private String summary; //abstract is a java keyword
	private String keywords;
	private String htmlUrl;
	private String pdfUrl;
	
	public String getTitle() {
		return title;
	}
	public Journal setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getJournal() {
		return journal;
	}
	public Journal setJournal(String journal) {
		this.journal = journal;
		return this;
	}
	public String getIssn() {
		return issn;
	}
	public Journal setIssn(String issn) {
		this.issn = issn;
		return this;
	}
	public String getEissn() {
		return eissn;
	}
	public Journal setEissn(String eissn) {
		this.eissn = eissn;
		return this;
	}
	public int getYear() {
		return year;
	}
	public Journal setYear(int year) {
		this.year = year;
		return this;
	}
	public int getMonth() {
		return month;
	}
	public Journal setMonth(int month) {
		this.month = month;
		return this;
	}
	public int getValume() {
		return valume;
	}
	public Journal setValume(int valume) {
		this.valume = valume;
		return this;
	}
	public int getIssue() {
		return issue;
	}
	public Journal setIssue(int issue) {
		this.issue = issue;
		return this;
	}
	public String getDoi() {
		return doi;
	}
	public Journal setDoi(String doi) {
		this.doi = doi;
		return this;
	}
	public int getPageStart() {
		return pageStart;
	}
	public Journal setPageStart(int pageStart) {
		this.pageStart = pageStart;
		return this;
	}
	public int getPageEnd() {
		return pageEnd;
	}
	public Journal setPageEnd(int pageEnd) {
		this.pageEnd = pageEnd;
		return this;
	}
	public String getAuthors() {
		return authors;
	}
	public Journal setAuthors(String authors) {
		this.authors = authors;
		return this;
	}
	public String getAffiliations() {
		return affiliations;
	}
	public Journal setAffiliations(String affiliations) {
		this.affiliations = affiliations;
		return this;
	}
	public String getSummary() {
		return summary;
	}
	public Journal setSummary(String summary) {
		this.summary = summary;
		return this;
	}
	public String getKeywords() {
		return keywords;
	}
	public Journal setKeywords(String keywords) {
		this.keywords = keywords;
		return this;
	}
	public String getHtmlUrl() {
		return htmlUrl;
	}
	public Journal setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
		return this;
	}
	public String getPdfUrl() {
		return pdfUrl;
	}
	public Journal setPdfUrl(String pdfUrl) {
		this.pdfUrl = pdfUrl;
		return this;
	}
	
	
}
