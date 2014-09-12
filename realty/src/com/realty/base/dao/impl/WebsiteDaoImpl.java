package com.realty.base.dao.impl;

import java.util.Date;
import java.util.List;

import com.realty.base.dao.WebsiteDao;
import com.realty.base.model.Culture;
import com.realty.base.model.Down;
import com.realty.base.model.Law;
import com.realty.base.model.Macro;
import com.realty.base.model.Micro;
import com.realty.base.model.News;
import com.realty.base.model.Project;
import com.realty.base.model.Research;
import com.realty.base.utils.HibernateDaoSupport;

public class WebsiteDaoImpl implements WebsiteDao {
	HibernateDaoSupport hds=new HibernateDaoSupport();
	@Override
	public boolean projectAdd(String title, int procategoryId, Date date,int browses,
			String contents, String proFile) {
		// TODO Auto-generated method stub
		Project project=new Project();
		project.setTitle(title);
		project.setProcategoryId(procategoryId);
		project.setDate(date);
		project.setBrowses(browses);
		project.setContents(contents);
		project.setProFile(proFile);
		hds.save(project);
		return true;
	}

	@Override
	public boolean projectUpdate(int projectId,String title,int browses,
			String contents, String proFile) {
		// TODO Auto-generated method stub
		Project project=new Project();
		project.setProjectId(projectId);
		project.setTitle(title);
		//project.setProcategoryId(procategoryId);
		//project.setDate(date);
		project.setBrowses(browses);
		project.setContents(contents);
		project.setProFile(proFile);
		hds.update(project);
		return true;
	}

	@Override
	public List<Project> projectList(int procategoryId) {
		// TODO Auto-generated method stub
		Object[] o={procategoryId};
		List<Project> list=hds.findByParameter("from Project where procategoryId=?",o);
		return list;
	}

	@Override
	public boolean projectDel(int projectId) {
		// TODO Auto-generated method stub
		Project project=new Project();
		project.setProjectId(projectId);
		project.setTitle("1");
		hds.delete(project);
		return true;
	}
	public List<Project> projectSearch(String title) {
		// TODO Auto-generated method stub
		Object[] o={title}; 
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		List<Project> list=hds.findByParameter("from Project where title like '%'+?+'%' ",o);
		return list;
	}
	public List<Project> projects() {
		// TODO Auto-generated method stub
		
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		List<Project> list=hds.findByParameter("from Project order by projectId desc");
		return list;
	}
	public List<Project> projects(int projectId) {
		// TODO Auto-generated method stub
		Object[] o={projectId}; 
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		List<Project> list=hds.findByParameter("from Project where projectId = ?",o);
		return list;
	}
	public List<Project> projectList(int pageNo,int pageSize,int procategoryId){
		Object[] o={procategoryId}; 
		String hql="from Project where procategoryId=?";
		List<Project> list=hds.findByParameter(hql, o, pageNo, pageSize);
		System.out.println(list.size());
		return list;
	}
	
	public boolean lawAdd(String title,int lawcategoryId,Date date,int browses,
			String contents,String lawFile,String company,String keyword,String summary) {
		// TODO Auto-generated method stub
		Law law=new Law();
		law.setName(title);
		law.setLawcategoryId(lawcategoryId);
		law.setNumber(browses);
		law.setDate(date);
		law.setContents(contents);
		law.setLawFile(lawFile);
		law.setCompany(company);
		law.setKeyword(keyword);
		law.setSummary(summary);
		law.setLawFile(lawFile);
		hds.save(law);
		return true;
	}
	public boolean lawUpdate(int lawId,String title,int browses,String contents,
			String lawFile,String company,String keyword,String summary) {
		// TODO Auto-generated method stub
		Law law=new Law();
		law.setLawId(lawId);
		law.setName(title);
		law.setNumber(browses);
		law.setContents(contents);
		law.setLawFile(lawFile);
		law.setKeyword(keyword);
		law.setSummary(summary);
		law.setCompany(company);
		hds.update(law);
		return true;
	}
	
	public boolean lawUpdate(int lawId,String lawFile) {
		// TODO Auto-generated method stub
		Object[] o={lawFile,lawId}; 
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		String sql="update law set law_file =? where law_id =?";
		//List list=hds.findByParameter("select location_photo from building_locationphoto l ,building b where l.building_id =b.building_id and b.building_id=?",o);
		int list=hds.batchsqlUpdate(sql,o);
		return true;
	}
	@Override
	public List<Law> lawList(int lawcategoryId) {
		// TODO Auto-generated method stub
		Object[] o={lawcategoryId};
		List<Law> list=hds.findByParameter("from Law where lawcategoryId=?",o);
		return list;
	}

	@Override
	public boolean lawDel(int lawId) {
		// TODO Auto-generated method stub
		Law law=new Law();
		law.setLawId(lawId);
		law.setName("1");
		hds.delete(law);
		return true;
	}
	public List<Law> lawSearch(String title) {
		// TODO Auto-generated method stub
		Object[] o={title}; 
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		List<Law> list=hds.findByParameter("from Law where name like '%'+?+'%' ",o);
		return list;
	}
	public List<Law> laws() {
		// TODO Auto-generated method stub
		
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		List<Law> list=hds.findByParameter("from Law order by lawId desc");
		return list;
	}
	public List<Law> laws(int lawId) {
		// TODO Auto-generated method stub
		Object[] o={lawId}; 
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		List<Law> list=hds.findByParameter("from Law where lawId = ?",o);
		return list;
	}
	public List<Law> lawList(int pageNo,int pageSize,int lawcategoryId){
		Object[] o={lawcategoryId}; 
		String hql="from Law where lawcategoryId=?";
		List<Law> list=hds.findByParameter(hql, o, pageNo, pageSize);
		System.out.println(list.size());
		return list;
	}

	
	@Override
	public boolean newsAdd(String title, int newscategoryId, Date date,int browses,
			String contents, String newsFile) {
		// TODO Auto-generated method stub
		News news=new News();
		news.setTitle(title);
		news.setNewscategoryId(newscategoryId);
		news.setDate(date);
		news.setBrowses(browses);
		news.setContents(contents);
		news.setNewsFile(newsFile);
		hds.save(news);
		return true;
	}

	@Override
	public boolean newsUpdate(int newsId,String title,int browses,
			String contents, String newsFile) {
		// TODO Auto-generated method stub
		News news=new News();
		news.setNewsId(newsId);
		news.setTitle(title);
		//News.setProcategoryId(procategoryId);
		//News.setDate(date);
		news.setBrowses(browses);
		news.setContents(contents);
		news.setNewsFile(newsFile);
		hds.update(news);
		return true;
	}

	@Override
	public List<News> newsList(int newscategoryId) {
		// TODO Auto-generated method stub
		Object[] o={newscategoryId};
		List<News> list=hds.findByParameter("from News where newscategoryId=?",o);
		return list;
	}

	@Override
	public boolean newsDel(int newsId) {
		// TODO Auto-generated method stub
		News news=new News();
		news.setNewsId(newsId);
		news.setTitle("1");
		hds.delete(news);
		return true;
	}
	public List<News> newsSearch(String title) {
		// TODO Auto-generated method stub
		Object[] o={title}; 
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		List<News> list=hds.findByParameter("from News where title like '%'+?+'%' ",o);
		return list;
	}
	public List<News> newsList(int pageNo,int pageSize,int newscategoryId){
		Object[] o={newscategoryId}; 
		String hql="from News where newscategoryId=?";
		List<News> list=hds.findByParameter(hql, o, pageNo, pageSize);
		return list;
	}
	public List<News> news(int newsId) {
		// TODO Auto-generated method stub
		Object[] o={newsId}; 
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		List<News> list=hds.findByParameter("from News where newsId = ?",o);
		return list;
	}

	
	public boolean macroAdd(String title, int macrochcategoryId, Date date,int browses,
			 String contents, String macroFile) {
		// TODO Auto-generated method stub
		Macro macro=new Macro();
		macro.setName(title);
		macro.setMacrocategoryId(macrochcategoryId);
		macro.setDate(date);
		macro.setNumber(browses);
		macro.setContents(contents);
		macro.setMacrocategoryFile(macroFile);
		hds.save(macro);
		return true;
	}

	
	public boolean macroUpdate(int macroId, String title, int browses,
			String contents, String macroFile) {
		// TODO Auto-generated method stub
		Macro macro=new Macro();
		macro.setMacroId(macroId);
		macro.setName(title);
		//research.setReschcategoryId(reschcategoryId);
		//research.setDate(date);
		macro.setNumber(browses);
		macro.setContents(contents);
		macro.setMacrocategoryFile(macroFile);
		hds.update(macro);
		return true;
	}

	
	public boolean macroDel(int macroId) {
		// TODO Auto-generated method stub
		Macro macro=new Macro();
		macro.setMacroId(macroId);
		macro.setName("1");
		hds.delete(macro);
		return true;
	}


	public List<Macro> macroSearch(String title) {
		// TODO Auto-generated method stub
		Object[] o={title}; 
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		List<Macro> list=hds.findByParameter("from Macro where name like '%'+?+'%' ",o);
		return list;
	}

	
	public List<Macro> macroList(int macrochcategoryId) {
		// TODO Auto-generated method stub
		Object[] o={macrochcategoryId};
		List<Macro> list=hds.findByParameter("from Macro where macrocategoryId=?",o);
		return list;
	}

	
	public List<Macro> macroList(int pageNo, int pageSize, int macrochcategoryId) {
		// TODO Auto-generated method stub
		Object[] o={macrochcategoryId}; 
		String hql="from Macro where macrocategoryId=?";
		List<Macro> list=hds.findByParameter(hql, o, pageNo, pageSize);
		
		return list;
	}
	
	public boolean microAdd(String title, int microchcategoryId, Date date,int browses,
			 String contents, String microFile) {
		// TODO Auto-generated method stub
		Micro micro=new Micro();
		micro.setName(title);
		micro.setMicrocategoryId(microchcategoryId);
		micro.setData(date);
		micro.setNumber(browses);
		micro.setContents(contents);
		micro.setMicrocategoryFile(microFile);
		hds.save(micro);
		return true;
	}

	
	public boolean microUpdate(int microId, String title, int browses,
			String contents, String microFile) {
		// TODO Auto-generated method stub
		Micro micro=new Micro();
		micro.setMicroId(microId);
		micro.setName(title);
		micro.setNumber(browses);
		micro.setContents(contents);
		micro.setMicrocategoryFile(microFile);
		hds.update(micro);
		return true;
	}

	
	public boolean microDel(int microId) {
		// TODO Auto-generated method stub
		Micro micro=new Micro();
		micro.setMicroId(microId);
		micro.setName("1");
		hds.delete(micro);
		return true;
	}


	public List<Micro> microSearch(String title) {
		// TODO Auto-generated method stub
		Object[] o={title}; 
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		List<Micro> list=hds.findByParameter("from Micro where name like '%'+?+'%' ",o);
		return list;
	}

	
	public List<Micro> microList(int microchcategoryId) {
		// TODO Auto-generated method stub
		Object[] o={microchcategoryId};
		List<Micro> list=hds.findByParameter("from Micro where microcategoryId=?",o);
		return list;
	}

	
	public List<Micro> microList(int pageNo, int pageSize, int microchcategoryId) {
		// TODO Auto-generated method stub
		Object[] o={microchcategoryId}; 
		String hql="from Micro where microcategoryId=?";
		List<Micro> list=hds.findByParameter(hql, o, pageNo, pageSize);
		return list;
	}
	
	public boolean researchAdd(String title, int reschcategoryId, Date date,
			int browses, String contents, String reschFile) {
		// TODO Auto-generated method stub
		Research research=new Research();
		research.setTitle(title);
		research.setReschcategoryId(reschcategoryId);
		research.setDate(date);
		research.setBrowses(browses);
		research.setContents(contents);
		research.setReschFile(reschFile);
		hds.save(research);
		return true;
	}

	@Override
	public boolean researchUpdate(int reschId, String title, int browses,
			String contents, String reschFile) {
		// TODO Auto-generated method stub
		Research research=new Research();
		research.setReschId(reschId);
		research.setTitle(title);
		//research.setReschcategoryId(reschcategoryId);
		//research.setDate(date);
		research.setBrowses(browses);
		research.setContents(contents);
		research.setReschFile(reschFile);
		hds.update(research);
		return true;
	}

	@Override
	public boolean researchDel(int reschId) {
		// TODO Auto-generated method stub
		Research research=new Research();
		research.setReschId(reschId);
		research.setTitle("1");
		hds.delete(research);
		return true;
	}

	@Override
	public List<Research> researchSearch(String title) {
		// TODO Auto-generated method stub
		Object[] o={title}; 
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		List<Research> list=hds.findByParameter("from Research where title like '%'+?+'%' ",o);
		return list;
	}

	@Override
	public List<Research> researchList(int reschcategoryId) {
		// TODO Auto-generated method stub
		Object[] o={reschcategoryId};
		List<Research> list=hds.findByParameter("from Research where reschcategoryId=?",o);
		return list;
	}

	@Override
	public List<Research> researchList(int pageNo, int pageSize, int reschcategoryId) {
		// TODO Auto-generated method stub
		Object[] o={reschcategoryId}; 
		String hql="from Research where reschcategoryId=?";
		List<Research> list=hds.findByParameter(hql, o, pageNo, pageSize);
		
		return list;
	}
	public List<Research> researchs(int researchId) {
		// TODO Auto-generated method stub
		Object[] o={researchId}; 
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		List<Research> list=hds.findByParameter("from Research where reschId = ?",o);
		return list;
	}
	
	public boolean cultureAdd(String title, int culcategoryId, Date date,int browses,
			String contents, String culFile) {
		// TODO Auto-generated method stub
		Culture culture=new Culture();
		culture.setTitle(title);
		culture.setCulcategoryId(culcategoryId);
		culture.setData(date);
		
		culture.setContents(contents);
		culture.setCulFile(culFile);
		hds.save(culture);
		return true;
	}


	public boolean cultureUpdate(int cultureId,String title,int browses,
			String contents, String culFile) {
		// TODO Auto-generated method stub
		Culture culture=new Culture();
		culture.setCultureId(cultureId);
		culture.setTitle(title);
		//News.setProcategoryId(procategoryId);
		//News.setDate(date);
		
		culture.setContents(contents);
		culture.setCulFile(culFile);
		hds.update(culture);
		return true;
	}


	public List<Culture> cultureList(int culcategoryId) {
		// TODO Auto-generated method stub
		Object[] o={culcategoryId};
		List<Culture> list=hds.findByParameter("from Culture where culcategoryId=?",o);
		return list;
	}


	public boolean cultureDel(int cultureId) {
		// TODO Auto-generated method stub
		Culture culture=new Culture();
		culture.setCultureId(cultureId);
		culture.setTitle("1");
		hds.delete(culture);
		return true;
	}
	public List<Culture> cultureSearch(String title) {
		// TODO Auto-generated method stub
		Object[] o={title}; 
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		List<Culture> list=hds.findByParameter("from Culture where title like '%'+?+'%' ",o);
		return list;
	}
	public List<Culture> cultureList(int pageNo,int pageSize,int culcategoryId){
		Object[] o={culcategoryId}; 
		String hql="from Culture where culcategoryId=?";
		List<Culture> list=hds.findByParameter(hql, o, pageNo, pageSize);
		return list;
	}
	public List<Culture> culture(int cultureId) {
		// TODO Auto-generated method stub
		Object[] o={cultureId}; 
		//List<Building> list=hds.findByParameter("from Building where buildingName like '%'+?+'%' ",o);
		List<Culture> list=hds.findByParameter("from Culture where cultureId = ?",o);
		return list;
	}


public boolean downAdd(String title, int downcategoryId, Date date,
			int downs, String downFile) { 
		// TODO Auto-generated method stub
		String contents=null;
		Down down=new Down();
		down.setTitle(title);
		down.setDowncategoryId(downcategoryId);
		down.setDate(date);
		down.setDowns(downs);
		down.setContents(contents);
		down.setDownFile(downFile);
		hds.save(down);
		return true;
	}	
	public List<Down> downList(int pageNo, int pageSize, int downcategoryId) {
		// TODO Auto-generated method stub
		Object[] o={downcategoryId}; 
		String hql="from Down where downcategoryId=?";
		List<Down> list=hds.findByParameter(hql, o, pageNo, pageSize);
		return list;
	}
	public List<Down> downList(int downcategoryId) {
		// TODO Auto-generated method stub
		Object[] o={downcategoryId};
		List<Down> list=hds.findByParameter("from Down where downcategoryId=?",o);
		return list;
	}
	public boolean downDel(int downId) {
		// TODO Auto-generated method stub
		Down down=new Down();
		down.setDownId(downId);
		hds.delete(down);
		return true;
	}
	
	
}
