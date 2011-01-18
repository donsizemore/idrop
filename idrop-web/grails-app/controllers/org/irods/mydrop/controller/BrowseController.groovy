package org.irods.mydrop.controller

import org.springframework.security.core.context.SecurityContextHolder;
import org.irods.jargon.core.pub.*;
import org.irods.jargon.core.connection.*;
import org.irods.jargon.core.exception.*;
import grails.converters.*;
import org.irods.jargon.core.query.CollectionAndDataObjectListingEntry;


/**
 * Controller for browser functionality
 * @author Mike Conway - DICE (www.irods.org)
 */

class BrowseController {
	
	IRODSAccessObjectFactory irodsAccessObjectFactory
	IRODSAccount irodsAccount
	
	/**
	 * Interceptor grabs IRODSAccount from the SecurityContextHolder
	 */
	def beforeInterceptor = {
		def irodsAuthentication = SecurityContextHolder.getContext().authentication
		
		if (irodsAuthentication == null) {
			throw new JargonRuntimeException("no irodsAuthentication in security context!")
		}
		
		irodsAccount = irodsAuthentication.irodsAccount
		log.debug("retrieved account for request: ${irodsAccount}")
	}
	
	
	/**
	 * Display initial browser
	 */
	def index = { }
	
	
	/**
	 * Render the tree node data for the given parent.  This will use the HTML style AJAX response to depict the children using unordered lists.
	 * <p/>
	 *  Requires param 'dir' from request to derive parent
	 *
	 */
	def loadTree = {   
		def parent = params['dir']
		log.info "loading tree for parent path: ${parent}"
		def collectionAndDataObjectListAndSearchAO = irodsAccessObjectFactory.getCollectionAndDataObjectListAndSearchAO(irodsAccount)
		def collectionAndDataObjectList = collectionAndDataObjectListAndSearchAO.listDataObjectsAndCollectionsUnderPath(parent)
		log.debug("retrieved collectionAndDataObjectList: ${collectionAndDataObjectList}")
		//render(view:"loadTree",model:[collectionAndDataObjectList:collectionAndDataObjectList, parent:parent])
		render collectionAndDataObjectList as JSON
	}
	
	def ajaxDirectoryListingUnderParent = {
		def parent = params['dir']
		log.info "ajaxDirectoryListingUnderParent path: ${parent}"
		def collectionAndDataObjectListAndSearchAO = irodsAccessObjectFactory.getCollectionAndDataObjectListAndSearchAO(irodsAccount)
		def collectionAndDataObjectList = collectionAndDataObjectListAndSearchAO.listDataObjectsAndCollectionsUnderPath(parent)
		log.debug("retrieved collectionAndDataObjectList: ${collectionAndDataObjectList}")
		
		def jsonBuff = []
		
		collectionAndDataObjectList.each { 
			
			def icon
			def state
			def type
			if (it.isDataObject()) {
				icon = "../images/file.png"
				state = "open"
				type = "file"
			} else {
				icon = "folder"
				state = "closed"
				type = "folder"
			}
			
			def attrBuf = ["id":it.formattedAbsolutePath, "rel":type]
			
			jsonBuff.add(
					["data": it.nodeLabelDisplayValue,"attr":attrBuf, "state":state,"icon":icon, "type":type]
					)
			
		}
		
		render jsonBuff as JSON
		
		/*
		 render(contentType:"text/json") {
		 children = array {
		 for (entry in collectionAndDataObjectList) {
		 data = entry.nodeValueForDisplay
		 attr = {id=entry.formattedAbsolutePath}
		 state="closed"
		 children=[]
		 if (entry.getObjectType == CollectionAndDataObjectListingEntry.ObjectType.COLLECTION) {
		 icon="folder"
		 } else {
		 icon="/"
		 }
		 }
		 }
		 }
		 */
		
	}
	
}
