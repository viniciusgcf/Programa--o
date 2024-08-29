<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class FeedController extends Controller
{
    public function index()
    {
        $users = [[
            'name' => 'Vini',
            'age' => '21'
        ],
            [
                'name' => 'Luan',
                'age' => '31'
            ],
            [
                'name' => 'Marcio',
                'age' => '15'
            ]];
        return view('feed', ['users' => $users]);
    }
}
