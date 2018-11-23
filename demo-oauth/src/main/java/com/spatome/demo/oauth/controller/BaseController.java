package com.spatome.demo.oauth.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.spatome.demo.oauth.factory.DaoFactory;
import com.spatome.demo.oauth.factory.ServiceFactory;
import com.spatome.demo.core.controller.BController;

public class BaseController extends BController
{

	@Autowired
	protected DaoFactory daoFactory;
	@Autowired
	protected ServiceFactory serviceFactory;

}