package com.realty.base.action;

import java.util.Date;
import java.util.List;

import com.realty.base.model.Culture;
import com.realty.base.model.Law;
import com.realty.base.model.Macro;
import com.realty.base.model.Micro;
import com.realty.base.model.News;
import com.realty.base.model.Project;
import com.realty.base.model.Research;
import com.realty.base.service.WebsiteService;
import com.realty.base.service.impl.WebsiteServiceImpl;


public class WebsiteAction {
	WebsiteService website=new WebsiteServiceImpl();
	 
	public boolean projectAdd(String title,int procategoryId,Date date,int browses,String contents,String proFile){
		return website.projectAdd(title,procategoryId,date,browses,contents,proFile);
	}
	public boolean projectUpdate(int projectId,String title,int browses,String contents,String proFile){
		return website.projectUpdate(projectId,title,browses,contents,proFile);
	}
	public List<Project> projectList(int procategoryId){
		return website.projectList(procategoryId);
	}
	public boolean projectDel(int projectId){
		return website.projectDel(projectId);
	}
	public List<Project> projects(){
		return website.projects();
	}
	public List<Project> projects(int projectId){
		return website.projects(projectId);
	}
	public List<Project> projectSearch(String title){
		return website.projectSearch(title);
	}
	public List<Project> projectList(int pageNo,int pageSize,int procategoryId){
		return website.projectList(pageNo, pageSize,procategoryId);
	}

	public boolean lawAdd(String title,int lawcategoryId,Date date,int browses,String contents,String lawFile,String company,String keyword,String summary){
		return website.lawAdd(title,lawcategoryId,date, browses, contents, lawFile, company, keyword, summary);
	}
	public boolean lawUpdate(int lawId,String title,int browses,String contents,String lawFile,String company,String keyword,String summary){
		return website.lawUpdate(lawId, title, browses, contents, lawFile, company, keyword, summary);
	}
	public List<Law> lawList(int lawcategoryId){
		return website.lawList(lawcategoryId);
	}
	public boolean lawDel(int lawId){
		return website.lawDel(lawId);
	}
	public List<Law> laws(){
		return website.laws();
	}
	public List<Law>laws(int lawId){
		return website.laws(lawId);
	}
	public List<Law> lawSearch(String title){
		return website.lawSearch(title);
	}
	public List<Law> lawList(int pageNo,int pageSize,int lawcategoryId){
		return website.lawList(pageNo, pageSize,lawcategoryId);
	}
	
	
	public boolean newsAdd(String title, int newscategoryId, Date date,
			int browses, String contents, String newsFile) {
		// TODO Auto-generated method stub
		return website.newsAdd(title, newscategoryId, date, browses, contents, newsFile);
	}
	public boolean newsUpdate(int newsId, String title, int browses,
			String contents, String newsFile) {
		// TODO Auto-generated method stub
		return website.newsUpdate(newsId, title, browses, contents, newsFile);
	}
	public List<News> newsList(int newscategoryId) {
		// TODO Auto-generated method stub
		return website.newsList(newscategoryId);
	}
	public boolean newsDel(int newsId) {
		// TODO Auto-generated method stub
		return website.newsDel(newsId);
	}
	public List<News> newsSearch(String title) {
		// TODO Auto-generated method stub
		return website.newsSearch(title);
	}
	public List<News> newsList(int pageNo, int pageSize, int newscategoryId) {
		// TODO Auto-generated method stub
		return website.newsList(pageNo, pageSize, newscategoryId);
	}
	public List<News> news(int newsId) {
		// TODO Auto-generated method stub
		return website.news(newsId);
	}
	
	public boolean researchAdd(String title, int reschcategoryId, Date date,
			int browses, String contents, String reschFile) {
		// TODO Auto-generated method stub
		return website.researchAdd(title, reschcategoryId, date, browses, contents, reschFile);
	}
	public boolean researchUpdate(int reschId, String title, int browses,
			String contents, String reschFile) {
		// TODO Auto-generated method stub
		return website.researchUpdate(reschId, title, browses, contents, reschFile);
	}
	public List<Research> researchList(int reschcategoryId) {
		// TODO Auto-generated method stub
		return website.researchList(reschcategoryId);
	}
	public boolean researchDel(int reschId) {
		// TODO Auto-generated method stub
		return website.researchDel(reschId);
	}
	public List<Research> researchSearch(String title) {
		// TODO Auto-generated method stub
		return website.researchSearch(title);
	}
	public List<Research> researchList(int pageNo, int pageSize, int reschcategoryId) {
		// TODO Auto-generated method stub
		return website.researchList(pageNo, pageSize, reschcategoryId);
	}
	public List<Research> researchs(int researchId){
		return website.researchs(researchId);
	}
	
	public boolean macroAdd(String title, int macrochcategoryId, Date date,int browses, String contents, String macroFile) {
		// TODO Auto-generated method stub
		return website.macroAdd(title, macrochcategoryId, date, browses, contents, macroFile);
	}
	public boolean macroUpdate(int macroId, String title, int browses,String contents, String macroFile) {
		// TODO Auto-generated method stub
		return website.macroUpdate(macroId, title, browses, contents, macroFile);
	}
	public boolean macroDel(int macroId) {
		// TODO Auto-generated method stub
		return website.macroDel(macroId);
	}
	public List<Macro> macroSearch(String title) {
		// TODO Auto-generated method stub
		return website.macroSearch(title);
	}
	public List<Macro> macroList(int marcocategoryId) {
		// TODO Auto-generated method stub
		return website.macroList(marcocategoryId);
	}
	public List<Macro> macroList(int pageNo, int pageSize, int macrocategoryId) {
		// TODO Auto-generated method stub
		return website.macroList(pageNo, pageSize, macrocategoryId);
	}
	
	public boolean microAdd(String title, int microchcategoryId, Date date,int browses, String contents, String microFile) {
		// TODO Auto-generated method stub
		return website.microAdd(title, microchcategoryId, date, browses, contents, microFile);
	}


	public boolean microUpdate(int microId, String title, int browses,String contents, String microFile) {
		// TODO Auto-generated method stub
		return website.microUpdate(microId, title, browses, contents, microFile);
	}	
	public boolean microDel(int microId) {
		// TODO Auto-generated method stub
		return website.microDel(microId);
	}	
	public List<Micro> microSearch(String title) {
		// TODO Auto-generated method stub
		return website.microSearch(title);
	}	
	public List<Micro> microList(int mircocategoryId) {
		// TODO Auto-generated method stub
		return website.microList(mircocategoryId);
	}
	public List<Micro> microList(int pageNo, int pageSize, int microcategoryId) {
		// TODO Auto-generated method stub
		return website.microList(pageNo, pageSize, microcategoryId);
	}
	
	
	public boolean cultureAdd(String title, int culcategoryId, Date date,int browses,String contents, String culFile){
		return website.cultureAdd(title, culcategoryId, date, browses, contents, culFile);
	}
	public boolean cultureUpdate(int cultureId,String title,int browses,String contents, String culFile){
		return website.cultureUpdate(cultureId, title, browses, contents, culFile);
	}
	public List<Culture> cultureList(int culcategoryId){
		return website.cultureList(culcategoryId);
	}
	public List<Culture> culture(int cultureId){
		return website.culture(cultureId);
	}
	public boolean cultureDel(int cultureId){
		return website.cultureDel(cultureId);
	}
	public List<Culture> cultureSearch(String title){
		return website.cultureSearch(title);
	}
	public List<Culture> cultureList(int pageNo,int pageSize,int culcategoryId){
		return website.cultureList(pageNo, pageSize, culcategoryId);
	}
}
