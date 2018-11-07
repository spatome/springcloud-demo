package com.spatome.demo.user.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.spatome.demo.user.factory.DaoFactory;
import com.spatome.demo.user.factory.ServiceFactory;

public class BaseController
{

	@Autowired
	protected DaoFactory daoFactory;
	@Autowired
	protected ServiceFactory serviceFactory;

}