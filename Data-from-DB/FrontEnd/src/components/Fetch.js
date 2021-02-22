// reference: https://swr.vercel.app/

import React from 'react';
import useSWR from 'swr';
import axios from 'axios';
import Display from './Display';

export default function Fetch() {

    const fetcher = url => axios.get(url).then(res => res.data)
    const { data, error } = useSWR('http://localhost:8080/test', fetcher)

    if (error) return <div>failed to load</div>
    if (!data) return <div>loading...</div>
    return <div><Display data={data}/></div>
}