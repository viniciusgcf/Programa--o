<?php

use App\Models\User;
use Illuminate\Support\Facades\Route;
use Illuminate\Support\Facades\Auth;

Route::get('/', function () {
    Auth::loginUsingId(1);

    $users = User::all();

    return view('welcome', ['users' => $users]);
});

Route::get('/user/create', function () {
    return view('user_create');
});

