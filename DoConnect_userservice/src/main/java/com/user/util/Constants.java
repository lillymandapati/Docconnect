package com.user.util;

public interface Constants   {
	public static final String DMS200 = "200";
	public static final String DMS101 = "101";
	public static final String DMS401 = "401";
	public static final String DMS100 = "100";
	public static final String DMS500 = "500";
	
	public static final int ADMIN_ROLE_ID = 1;
	public static final int USER_ROLE_ID = 2;

	public static final String SUCCESS = "Success";
	public static final String UPDATE_SUCCESS = "Update success";
	public static final String NO_RECORDS_FOUND = "No records found";
	public static final String INTERNAL_SERVER_ERROR = "Internal server error";
	public static final String VALIDATION_FAILED = "Validation failed";
	public static final String UNAUTHORIZED = "Unauthorized";

	public static final String WELCOME = "Welcome to DoConnectPage";
	public static final String APPROVAL_NEEDED = "Get Approval From Admin";
	public static final String EMPLOYEE_ID_ALREADY_EXISTS = "EmployeeId already exists";
	public static final String SELF = "Self";
	public static final String INVALID_ROLE_ID = "Invalid role id";
	public static final String CONFIRM_PASSWORD_NOT_MATCH = "Password donot match";
	public static final String INVALID_PASSWORD = "Incorrect password";
	public static final String EMAIL_DOES_NOT_EXISTS = "Email doesn't exists";
	public static final String EMAIL_ALREADY_EXISTS = "Email already exists";
	public static final String USER_NOT_EXISTS = "User doesnot exist";
	public static final String USER_NOT_EXISTS_OR_DELETED = "User doesnot exist or deleted";

	public static final String INVALID_EMPLOYEEID_FORMET = "Invalid employeeId format. Please provide a valid numeric value.";
	public static final String USER_DELETED = "Deleted successfully";
	public static final String ALREADY_DELETED = "Already Deleted";
	public static final String NOT_MATCH = "Passwords do not match";
	public static final String EMPLOYEE_ID_DOESNOT_EXIST = "EmployeeId doesnot exist";
	public static final String PURCHASE_ID_DOESNOT_EXIST = "Purchase doesnot exist";
	public static final String PROJECT_NOT_ASSIGNED_TO_USER = "Project not assigned to user";

	public static final String OTP_GENERATED = "OTP generated";

	public static final String VALIDATE_SUCESS = "Validation success";
	public static final String VALIDATE_FAIL = "Invalid Otp";
	public static final String NUMBER_FORMAT_EXCEPTION = "Number format exception";
	
	public static final String ACTIVE = "Active";
	
	public static final String PROJECT_ALREADY_EXIST = "Project already exists";
	public static final String DEACTIVE_SUCCESS = "Deactivate successfully";

	public static final String Approved = "Approved";

	// ---------------------------------------------------------------------

	public static final String USER_NOT_NULL = "User name should not be null or empty";
	public static final String PROJECT_NOT_NULL = "Project name should not be null or empty";
	public static final String EMPLOYEE_ID_NOT_NULL = "EmployeeId should not be null or empty";
	public static final String PROJECT_NOT_VALID = "timehours should not be null or empty";

	public static final String EMPLOYEE_ALREADY_EXISTS = " Check Your EmployeeId already exists";
	
	public static final String INVALID_USER = "Incorrect username Or password";
	public static final String INVALID_EMAIL = "Invalid Email";
	public static final String INVALID_INPUTS = "Username should accept only alphabet";
	public static final String USERNAME_CHARACTER_LIMIT = "Username should have at least min 2 characters and max 25 characters";
	public static final String COMPANY_CHARACTER_LIMIT = "Company name should have at least min 2 characters and max 30 characters";
	public static final String VALID_PASSWORD = "The password should have at least 6 characters min, 1 Upper case letter , 1 lower case letter,1 Number , 1 special characters";
	public static final String VALID_CONFIRM_PASSWORD = "The confirm password should have at least 6 characters min, 1 Upper case letter , 1 lower case letter , 1 Number , 1 special characters";
	public static final String ALLOW_ALPHABETS_AND_DIGIT = "Invalid EmployeeId";
	public static final String EMPLOYEE_ID_CHARACTER_LIMIT = "EmployeeId should have at least min 2 characters and max 25 characters";
	public static final String INVALID_COMPANY_INPUTS = "Invalid Company Name";
	public static final String COMPANY_NOT_NULL = "Company name should not be null or empty";
	public static final String EMAIL_NOT_NULL = "Email should not be null or empty";
	public static final String PASSWORD_NOT_NULL = "Password should not be null or empty";
	public static final String CONFIRM_PASSWORD_NOT_NULL = "Confirm password should not be null or empty";
	public static final String EMAIL_INVALID_INPUTS = "Invalid Email";
	public static final String PENDING = "PENDING";
	public static final String FAIL = "FAIL";
	public static final String FAILED = "FAILED";
	
	public static final String FILE_UPLOAD_SUCCESS = "FILE_UPLOAD SUCCESSFULLY";
	public static final String ERROR = "An error occurred during file upload.";
	public static final String USER_DELETED_SUCCESS ="user deleted Sucessfully";
	public static final String USER_NOT_EXIST="user not existed in db ";
	public static final String USER_ALREADY_DELETED="user alredy deleted ";
	public static final String FILE_NOTFOUND = "File not found: ";
	public static final String ERROR_DOWNLOADFILE = "An error occurred during file download.";
	public static final String APPROVAL_Needed = "Need to get Approval From Admin";
	public static final String APPROVAL = " Approval Success From Admin";
	public static final String ALREADY_EXIT = "This Project is Already Exist";
	public static final String NOT_EXITS = "This User detail is Empty";
	
	public static final String FILE_DELETED_SUCCESS="deleted file sucessfully";
	public static final String NOT_EXIST="file not existed in path";

	// JWT
	public static final String JWT_KEY = "jwt_key";
	public static final String JWT_EXPIRATION = "jwt_expiration";

	public static final String INVALID_USER1 = "Invalid User";
	public static final String REGISTERATION_SUCCESSFUL = "Registration successfully";
	public static final String LOGIN_SUCCESSFULL = "Login Successful";
	public static final String PASSWORD_DETAILS_UPDATED = "Password details updated";
	public static final String INCORRECT_PASSWORD = "The password should have at least 6 characters min, 1 Upper case letter , 1 lower case letter , 1 special characters, 1 numeric value";
	public static final String INCORRECT_CONFIRM_PASSWORD = "ConfirmPassword Should Not Be Null or Empty";
	public static final String PASSWORD_SHOULD_BE_SAME = "Password and confirm password should Be Same";
	public static final String PASSWORD_SHOULD_BE_UNIQUE = "Password entered should be unique from the existing one";
	public static final String EMAIL_ID_IS_EMPTY = "Email Id should not empty";
	public static final String INVALID = "Invalid";
	
	public static final String SELECT_DOCUMENT = "Please Select Document File";
	public static final String FILE_SIZE = "File size too large!!";
	public static final String FAILED_UPLOAD = "Failed to upload the file.";

	public static final String NOT_AVAILABLE = "requirement search is not available";
	public static final String ERROR_ADDING_CHANGE = "Error occurred while adding change:";
	public static final String NOT_EXISTFILE = "this file is not Existed";
	public static final String FILE_UPLOAD_SUCESS = "File updated successfully.";
	public static final String FAILD_UPLODEDFILE = "fail to File updated successfully.";
	public static final String INTENAL_ERROR = "Error occurred during search Documents: ";
	public static final String SHIP_NAME_ALREADY_EXIST = "Ship Name already exists";
	public static final String INVALID_SHIP = "Invalid Ship";
	public static final String INVALID_SHIP_NAME = "Invalid Ship Name";
	public static final String SHIP_ADDED = "Ship details added successfully";
	public static final String File_NAME_ALREADY_EXIST = "File already exists";
	public static final String SERVEY_ADDED = "Survey details added successfully";
	public static final String IMO_NOT_NULL = "IMO number should not be null or empty";
	public static final String INVALID_IMO_NUMBER = "Invalid ship IMONumber";
	public static final String INVALID_SHIP_ID = "Invalide ShipId";
	public static final String INVALID_PORT_NAME = "Invalide PortName";
	public static final String INVALID_DISTANCE = "Invalide Distance value";

	public static final String ROLE_ID_IS_EMPTY = "Role Id should not empty";
	public static final String INVALID_ROLE_ID_ = "Role Id is invalid";

	public static final String WELCOME_As_USER = "Welcome to Beauto System";
	public static final String INVALID_USERNAME_PASSWORD = "invalid username/password";
	public static final String AN_ERROR_DURING_USER_REGISTRATION = "An error occurred during user registration.";
	public static final String AN_ERROR_OCCURRED_DURING_FILE_GENERATION = "An error occurred during file generation.";
	public static final String UPDATE_FAIL = "Update fail";
	public static final String FILE_EDIT_SUCCESS = "File edited successfully ";
	public static final String FAILED_EDIT_FILE = "File edited failed";
	public static final String FILE_UPDATE_SUCCESS = "FILE_UPDATE_SUCCESS";
	
	public static final String FILE_NOT_EXIST = "File not exits or already deleted";
	public static final String FILE_DELETED_SUCCESSFULLY = "File deleted successful";
	public static final String FAILED_TO_DELETE_FILE = "Failed to delete file";
	public static final String FILE_DIRECTORY_FAIL ="File or directory not found for this user";
	public static final String USER_FOLDER_DELETED_SUCCESSFULLY = "User Folder deleted successful";
	public static final String FAILED_TO_UPLOAD_FILE = "Failed to upload file";
	public static final String FILE_UPLOADED_SUCCESSFULLY = "File uploaded successful";
	public static final String PLEASE_SELECT_A_FILE_TO_UPLOAD = "Please select a file to upload";
	public static final String NO_EXISTING_FOLDER_FOUND = "No exiting folder found";
	public static final String NOT_ACCESS = "You do not have permission to access this resource";
	public static final String SIZE_File = "Maximum upload size exceeded. Please upload a smaller file.";

	public static final String FILE_NOT_FOUND ="FILE_NOT_EXIST" ;

}
