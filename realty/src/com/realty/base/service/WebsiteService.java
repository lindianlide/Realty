package com.realty.base.service;

import java.util.Date;
import java.util.List;

import com.realty.base.model.Culture;
import com.realty.base.model.Law;
import com.realty.base.model.Macro;
import com.realty.base.model.Micro;
import com.realty.base.model.News;
import com.realty.base.model.Project;
import com.realty.base.model.Research;

public interface WebsiteService {
	public boolean projectAdd(String title,int procategoryId,Date date, int browses,String contents,String proFile);
	public boolean projectUpdate(int projectId,String title,int browses,String contents,String proFile);
	public List<Project> projectList(int procategoryId);
	public boolean projectDel(int projectId);
	public List<Project> projectSearch(String title);
	public List<Project> projects();
	public List<Project> projects(int projectId);
	public List<Project> projectList(int pageNo,int pageSize,int procategoryId);
	public boolean lawAdd(String title,int lawcategoryId,Date date,int browses,String contents,String lawFile,String company,String keyword,String summary);
	public boolean lawUpdate(int lawId,String title,int browses,String contents,String lawFile,String company,String keyword,String summary);
	public List<Law> lawList(int lawcategoryId);
	public boolean lawDel(int lawId);
	public List<Law> lawSearch(String title);
	public List<Law> laws();
	public List<Law> laws(int lawId);
	public List<Law> lawList(int pageNo,int pageSize,int lawcategoryId);
	
	public boolean newsAdd(String title, int newscategoryId, Date date,int browses,String contents, String newsFile);
	public boolean newsUpdate(int newsId,String title,int browses,String contents, String newsFile);
	public List<News> newsList(int newscategoryId);
	public List<News> news(int newsId);
	public boolean newsDel(int newsId);
	public List<News> newsSearch(String title);
	public List<News> newsList(int pageNo,int pageSize,int newscategoryId);
	
	public boolean researchAdd(String title, int reschcategoryId, Date date,int browses, String contents, String reschFile);
	public boolean researchUpdate(int reschId, String title, int browses,String contents, String reschFile);
	public boolean researchDel(int reschId);
	public List<Research> researchSearch(String title);
	public List<Research> researchList(int reschcategoryId);
	public List<Research> researchList(int pageNo, int pageSize, int reschcategoryId);
	public List<Research> researchs(int researchId);
	
	boolean macroAdd(String title, int macrochcategoryId, Date date,int browses, String contents, String macroFile);
	boolean macroUpdate(int macroId, String title, int browses,String contents, String macroFile);
	boolean macroDel(int macroId);
	List<Macro> macroSearch(String title);
	List<Macro> macroList(int marcocategoryId);
	List<Macro> macroList(int pageNo, int pageSize, int macrocategoryId);
	
	boolean microAdd(String title, int microchcategoryId, Date date,int browses, String contents, String microFile);
	boolean microUpdate(int microId, String title, int browses,String contents, String microFile);
	boolean microDel(int microId);
	List<Micro> microSearch(String title);
	List<Micro> microList(int mircocategoryId);
	List<Micro> microList(int pageNo, int pageSize, int microcategoryId);
	
	public boolean cultureAdd(String title, int culcategoryId, Date date,int browses,String contents, String culFile);
	public boolean cultureUpdate(int cultureId,String title,int browses,String contents, String culFile);
	public List<Culture> cultureList(int culcategoryId);
	public List<Culture> culture(int cultureId);
	public boolean cultureDel(int cultureId);
	public List<Culture> cultureSearch(String title);
	public List<Culture> cultureList(int pageNo,int pageSize,int culcategoryId);
}
