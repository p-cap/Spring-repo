// Reference: https://material-ui.com/components/tables/


import React from 'react';

// table
import Paper from '@material-ui/core/Paper';
import TableContainer from '@material-ui/core/TableContainer';
import Table from '@material-ui/core/Table';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import TableCell from '@material-ui/core/TableCell';
import TableBody from '@material-ui/core/TableBody';

// styling
import { Typography } from '@material-ui/core';
import { withStyles } from '@material-ui/core/styles';

const StyledTableCell = withStyles((theme) => ({
    head: {
      backgroundColor: theme.palette.common.black,
      color: theme.palette.common.white,
    }
}))(TableCell)

const StyledTableRow = withStyles((theme) => ({
    root: {
      '&:nth-of-type(odd)': {
        backgroundColor: theme.palette.action.hover,
      },
    },
  }))(TableRow);


export default function Display(props) {
    const results = props.data
    return( 
        <div>
            <Typography 
                    variant="h2"
                    align="center"
                    > Material-UI / ExpressJS / Spring-boot / PostgresSQL </Typography>
            <Typography 
                    variant="h6"
                    align="center"
                    > This site pulls data from PostgresSQL Database</Typography>
                <TableContainer component={Paper}>
                    <Table>
                        <TableHead>
                            <TableRow>
                                <StyledTableCell> IP </StyledTableCell>
                                <StyledTableCell> Domain </StyledTableCell>
                                <StyledTableCell> User Agent </StyledTableCell>
                                <StyledTableCell> URL </StyledTableCell>                 
                            </TableRow>
                        </TableHead>
                        <TableBody>
                            {   
                                results.map((item, index) => (
                                    <StyledTableRow key={index}>
                                        <TableCell scope="row">{item.ip}</TableCell>
                                        <TableCell>{item.domain}</TableCell>
                                        <TableCell>{item.useragent}</TableCell>
                                        <TableCell><span style={{ 
                                            width: '250px',
                                            wordWrap: 'break-word'
                                            }}>{item.url}</span></TableCell>
                                    </StyledTableRow>
                                ))
                            }   
                        </TableBody>
                    </Table>
                </TableContainer>
                </div>
    )
}


