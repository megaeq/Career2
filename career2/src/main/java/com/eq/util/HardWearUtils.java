package com.eq.util;

import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.junit.Test;

public class HardWearUtils
{
	@Test
	public void testCpuPerc()
	{
		Sigar sigar = new Sigar();
		// 方式一，主要是针对一块CPU的情况
		CpuPerc cpu;
		try
		{
			cpu = sigar.getCpuPerc();
			printCpuPerc(cpu);
		}
		catch (SigarException e)
		{
			e.printStackTrace();
		}
		// 方式二，不管是单块CPU还是多CPU都适用
		CpuPerc cpuList[] = null;
		try
		{
			cpuList = sigar.getCpuPercList();
		}
		catch (SigarException e)
		{
			e.printStackTrace();
			return;
		}
		for (int i = 0; i < cpuList.length; i++)
		{
			printCpuPerc(cpuList[i]);
		}
	}

	private void printCpuPerc(CpuPerc cpu)
	{
		System.out.println("User :" + CpuPerc.format(cpu.getUser()));// 用户使用率
		System.out.println("Sys :" + CpuPerc.format(cpu.getSys()));// 系统使用率
		System.out.println("Wait :" + CpuPerc.format(cpu.getWait()));// 当前等待率
		System.out.println("Nice :" + CpuPerc.format(cpu.getNice()));//
		System.out.println("Idle :" + CpuPerc.format(cpu.getIdle()));// 当前空闲率
		System.out.println("Total :" + CpuPerc.format(cpu.getCombined()));// 总的使用率
	}
}
