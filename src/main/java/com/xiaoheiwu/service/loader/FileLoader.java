package com.xiaoheiwu.service.loader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.xiaoheiwu.service.Car;

public abstract class FileLoader extends AbstractLoader{
	protected String filePath=null;
	
	public FileLoader(String filePath) {
		this.filePath=filePath;
	}
	
	@Override
	protected Iterator<Car> load() {
		List<Car> cars=new ArrayList<Car>();
		try {
			BufferedReader br=new BufferedReader(new FileReader(filePath));
			String line =br.readLine();
			while(line!=null){
				if(line.trim().equals(""))continue;
				Car car=parserLine(line);
				cars.add(car);
				line =br.readLine();
			}
			return cars.iterator();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	/**

	 * @param line
	 * @return
	 */
	protected abstract Car parserLine(String line);
}
