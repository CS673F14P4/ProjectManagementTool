/**
 * author: Mariana Arantes 
 */

/*  date format */
function dateFormat (str) {
	var size = str.length;
	var newStr = str;
	
	// regular expression to check if the character is a number
	var re = /^\d$/;
	
	// get last character inserted
	var lastInserted = str.substring(size - 1, size);

	// don't allow non numbers
	if (re.test(lastInserted) != true || size > 10) {
		newStr = str.substring(0, size - 1);
	}
	// validate
	else {
		// insert mask
		if (size == 2 || size == 5) {
			newStr = str + '/';
		}
	}
	return newStr;
}

/* leap year */
function leapYear (year, yearLastDigits) {
			
	if (yearLastDigits == "00") {
		if ((year % 400) == 0) return true;
	}else {
		if ((year % 4) == 0) return true;
	}
	
	return false;
}


/* validate date */
function validation (date) {
	var month = Number(date.substring(0, 2));
	var day = Number(date.substring(3, 5));
	var year = Number(date.substring(6,10));
	var yearLastDigits = date.substring(8,10);
		
	// check month
	if (month < 1 || month > 12) {
		return false;
	}
	
	// check day
	if (day < 1) return false;
	
	// months with 31 days
	if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
		if (day > 31) return false;
	
	//months with 30 days
	}else if (month == 4 || month == 6 || month == 9 || month == 11) {
		if (day > 30) return false;
	}
	// February
	else {
		if (leapYear(year, yearLastDigits)) {
			if (day > 29) return false;
		}else {
			if (day > 28) return false;
		}
	}
	
	return true;
	
}
