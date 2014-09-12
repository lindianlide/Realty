package com.realty.base.service.impl;

import java.util.Date;
import java.util.List;

import com.realty.base.dao.WebsiteDao;
import com.realty.base.dao.impl.WebsiteDaoImpl;
import com.realty.base.model.Culture;
import com.realty.base.model.Law;
import com.realty.base.model.Macro;
import com.realty.base.model.Micro;
import com.realty.base.model.News;
import com.realty.base.model.Project;
import com.realty.base.model.Research;
import com.realty.base.service.WebsiteService;

public class WebsiteServiceImpl implements WebsiteService {
	WebsiteDao websiteDao=new WebsiteDaoImpl();
	@Override
	public boolean projectAdd(String title, int procategoryId, Date date,int browses,
			String contents, String proFile) {
		// TODO Auto-generated method stub
		return websiteDao.projectAdd(title,procategoryId,date,browses,contents,proFile);
	}

	@Override
	public boolean projectUpdate(int projectId,String title,int browses,
			String contents, String proFile) {
		// TODO Auto-generated method stub
		return websiteDao.projectUpdate(projectId,title,browses,contents,proFile);
	}

	@Override
	public List<Project> projectList(int procategoryId) {
		// TODO Auto-generated method stub
		return websiteDao.projectList(procategoryId);
	}
	public List<Project> projects() {
		// TODO Auto-generated method stub
		return websiteDao.projects();
	}
	public List<Project> projects(int projectId) {
		// TODO Auto-generated method stub
		return websiteDao.projects(projectId);
	}
	@Override
	public boolean projectDel(int projectId) {
		// TODO Auto-generated method stub
		return websiteDao.projectDel(projectId);
	}
	public List<Project> projectSearch(String title){
		return websiteDao.projectSearch(title);
	}
	public List<Project> projectList(int pageNo,int pageSize,int procategoryId){
		return websiteDao.projectList(pageNo, pageSize,procategoryId);
	}
	@Override
	public boolean lawAdd(String title,int lawcategoryId,Date date,int browses,String contents,String lawFile,String company,String keyword,String summary){
		// TODO Auto-generated method stub
		return websiteDao.lawAdd(title,lawcategoryId,date, browses, contents, lawFile, company, keyword, summary);
	}
	@Override
	public boolean lawUpdate(int lawId,String title,int browses,String contents,String lawFile,String company,String keyword,String summary){
		return websiteDao.lawUpdate(lawId, title, browses, contents, lawFile, company, keyword, summary);
	}
	@Override
	public List<Law> lawList(int lawcategoryId) {
		// TODO Auto-generated method stub
		return websiteDao.lawList(lawcategoryId);
	}
	public List<Law> laws() {
		// TODO Auto-generated method stub
		return websiteDao.laws();
	}
	public List<Law> laws(int lawId) {
		// TODO Auto-generated method stub
		return websiteDao.laws(lawId);
	}
	@Override
	public boolean lawDel(int lawId) {
		// TODO Auto-generated method stub
		return websiteDao.lawDel(lawId);
	}
	public List<Law> lawSearch(String title){
		return websiteDao.lawSearch(title);
	}
	public List<Law> lawList(int pageNo,int pageSize,int lawcategoryId){
		return websiteDao.lawList(pageNo, pageSize,lawcategoryId);
	}

	@Override
	public boolean newsAdd(String title, int newscategoryId, Date date,
			int browses, String contents, String newsFile) {
		// TODO Auto-generated method stub
		return websiteDao.newsAdd(title, newscategoryId, date, browses, contents, newsFile);
	}

	@Override
	public boolean newsUpdate(int newsId, String title, int browses,
			String contents, String newsFile) {
		// TODO Auto-generated method stub
		return websiteDao.newsUpdate(newsId, title, browses, contents, newsFile);
	}

	@Override
	public List<News> newsList(int newscategoryId) {
		// TODO Auto-generated method stub
		return websiteDao.newsList(newscategoryId);
	}
	public List<News> news(int newsId) {
		// TODO Auto-generated method stub
		return websiteDao.news(newsId);
	}

	@Override
	public boolean newsDel(int newsId) {
		// TODO Auto-generated method stub
		return websiteDao.newsDel(newsId);
	}

	@Override
	public List<News> newsSearch(String title) {
		// TODO Auto-generated method stub
		return websiteDao.newsSearch(title);
	}

	@Override
	public List<News> newsList(int pageNo, int pageSize, int newscategoryId) {
		// TODO Auto-generated method stub
		return websiteDao.newsList(pageNo, pageSize, newscategoryId);
	}

	@Override
	public boolean researchAdd(String title, int reschcategoryId, Date date,
			int browses, String contents, String reschFile) {
		// TODO Auto-generated method stub
		return websiteDao.researchAdd(title, reschcategoryId, date, browses, contents, reschFile);
	}

	@Override
	public boolean researchUpdate(int reschId, String title, int browses,
			String contents, String reschFile) {
		// TODO Auto-generated method stub
		return websiteDao.researchUpdate(reschId, title, browses, contents, reschFile);
	}

	@Override
	public boolean researchDel(int reschId) {
		// TODO Auto-generated method stub
		return websiteDao.researchDel(reschId);
	}

	@Override
	public List<Research> researchSearch(String title) {
		// TODO Auto-generated method stub
		return websiteDao.researchSearch(title);
	}

	@Override
	public List<Research> researchList(int reschcategoryId) {
		// TODO Auto-generated method stub
		return websiteDao.researchList(reschcategoryId);
	}

	@Override
	public List<Research> researchList(int pageNo, int pageSize, int reschcategoryId) {
		// TODO Auto-generated method stub
		return websiteDao.researchList(pageNo, pageSize, reschcategoryId);
	}
	public List<Research> researchs(int researchId){
		return websiteDao.researchs(researchId);
	}
	
	@Override
	public boolean macroAdd(String title, int macrochcategoryId, Date date,int browses, String contents, String macroFile) {
		// TODO Auto-generated method stub
		return websiteDao.macroAdd(title, macrochcategoryId, date, browses, contents, macroFile);
	}

	@Override
	public boolean macroUpdate(int macroId, String title, int browses,String contents, String macroFile) {
		// TODO Auto-generated method stub
		return websiteDao.macroUpdate(macroId, title, browses, contents, macroFile);
	}

	@Override
	public boolean macroDel(int macroId) {
		// TODO Auto-generated method stub
		return websiteDao.macroDel(macroId);
	}

	@Override
	public List<Macro> macroSearch(String title) {
		// TODO Auto-generated method stub
		return websiteDao.macroSearch(title);
	}

	@Override
	public List<Macro> macroList(int marcocategoryId) {
		// TODO Auto-generated method stub
		return websiteDao.macroList(marcocategoryId);
	}

	@Override
	public List<Macro> macroList(int pageNo, int pageSize, int macrocategoryId) {
		// TODO Auto-generated method stub
		return websiteDao.macroList(pageNo, pageSize, macrocategoryId);
	}
	
	@Override
	public boolean microAdd(String title, int microchcategoryId, Date date,int browses, String contents, String microFile) {
		// TODO Auto-generated method stub
		return websiteDao.microAdd(title, microchcategoryId, date, browses, contents, microFile);
	}

	@Override
	public boolean microUpdate(int microId, String title, int browses,String contents, String microFile) {
		// TODO Auto-generated method stub
		return websiteDao.microUpdate(microId, title, browses, contents, microFile);
	}

	@Override
	public boolean microDel(int microId) {
		// TODO Auto-generated method stub
		return websiteDao.microDel(microId);
	}

	@Override
	public List<Micro> microSearch(String title) {
		// TODO Auto-generated method stub
		return websiteDao.microSearch(title);
	}

	@Override
	public List<Micro> microList(int mircocategoryId) {
		// TODO Auto-generated method stub
		return websiteDao.microList(mircocategoryId);
	}

	@Override
	public List<Micro> microList(int pageNo, int pageSize, int microcategoryId) {
		// TODO Auto-generated method stub
		return websiteDao.microList(pageNo, pageSize, microcategoryId);
	}
	
	public boolean cultureAdd(String title, int culcategoryId, Date date,int browses,String contents, String culFile){
		return websiteDao.cultureAdd(title, culcategoryId, date, browses, contents, culFile);
	}
	public boolean cultureUpdate(int cultureId,String title,int browses,String contents, String culFile){
		return websiteDao.cultureUpdate(cultureId, title, browses, contents, culFile);
	}
	public List<Culture> cultureList(int culcategoryId){
		return websiteDao.cultureList(culcategoryId);
	}
	public List<Culture> culture(int cultureId){
		return websiteDao.culture(cultureId);
	}
	public boolean cultureDel(int cultureId){
		return websiteDao.cultureDel(cultureId);
	}
	public List<Culture> cultureSearch(String title){
		return websiteDao.cultureSearch(title);
	}
	public List<Culture> cultureList(int pageNo,int pageSize,int culcategoryId){
		return websiteDao.cultureList(pageNo, pageSize, culcategoryId);
	}
}
