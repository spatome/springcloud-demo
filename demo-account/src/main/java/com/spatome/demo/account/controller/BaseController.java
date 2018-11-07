package com.spatome.demo.account.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.spatome.demo.account.factory.DaoFactory;
import com.spatome.demo.account.factory.ServiceFactory;
import com.spatome.demo.core.controller.BController;

public class BaseController extends BController
{

	@Autowired
	protected ServiceFactory serviceFactory;
	@Autowired
	protected DaoFactory daoFactory;

}