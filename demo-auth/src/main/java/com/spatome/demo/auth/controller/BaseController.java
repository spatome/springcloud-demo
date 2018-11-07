package com.spatome.demo.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.spatome.demo.auth.factory.DaoFactory;
import com.spatome.demo.auth.factory.ServiceFactory;
import com.spatome.demo.core.controller.BController;

public class BaseController extends BController
{

	@Autowired
	protected DaoFactory daoFactory;
	@Autowired
	protected ServiceFactory serviceFactory;

}