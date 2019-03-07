/*
 * This is a javascript to use view forms(*.jsp)
 * 그래도 깨지잖어!
*/
function writeSave(){
	
	if(document.writeform.b_writer.value==""){
	  alert("Enter your name 이름을 넣어라");
	  document.writeform.b_writer.focus();
	  return false;
	}
	if(document.writeform.b_subject.value==""){
	  alert("Enter a subject");
	  document.writeform.b_subject.focus();
	  return false;
	}
	
	if(document.writeform.b_content.value==""){
	  alert("Enter a content");
	  document.writeform.b_content.focus();
	  return false;
	}       
	
	if(document.searchForm.keyword.value==""){
		  alert("Enter a keyword");
		  document.searchForm.keyword.focus();
		  return false;
	}
	if(document.fileWriteForm.b_writer.value==""){
		  alert("Enter your name");
		  document.fileWriteForm.b_writer.focus();
		  return false;
	}
	
	if(document.fileWriteForm.b_subject.value==""){
		  alert("Enter a subject");
		  document.fileWriteForm.b_subject.focus();
		  return false;
	}
	
	if(document.fileWriteForm.m_id.value==""){
		  alert("Enter your memberID");
		  document.fileWriteForm.m_id.focus();
		  return false;
	}
	
	if(document.fileWriteForm.i_id.value==""){
		  alert("Enter your itemID");
		  document.fileWriteForm.i_id.focus();
		  return false;
	}
	
	if(document.writeUpdateform.b_writer.value==""){
		  alert("Enter your name");
		  document.fileUploadForm.b_writer.focus();
		  return false;
	}
	
	if(document.writeUpdateform.b_subject.value==""){
		  alert("Enter a subject");
		  document.fileUploadForm.b_subject.focus();
		  return false;
	}
	
	if(document.writeUpdateform.m_id.value==""){
		  alert("Enter your memberID");
		  document.fileUploadForm.m_id.focus();
		  return false;
	}
	
	if(document.writeUpdateform.i_id.value==""){
		  alert("Enter your itemID");
		  document.fileUploadForm.i_id.focus();
		  return false;
	}
	
	
 }    

