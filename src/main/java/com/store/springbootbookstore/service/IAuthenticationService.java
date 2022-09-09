package com.store.springbootbookstore.service;

import com.store.springbootbookstore.exceptions.ExceptionResponse;
import com.store.springbootbookstore.model.User;

public interface IAuthenticationService {


    User signInAndReturnJwt(User signInRequest);
}
