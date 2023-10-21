import {
    IconButton, Paper, Table, TableBody, TableCell,
    TableContainer, TableHead, TableRow, useMediaQuery, useTheme
} from '@mui/material';
import React from 'react';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';

const tablerow = [
    "add_id", "Street", "City", "Country", "Number", "Zipcode", "actions"
]

const TableAddress = (props) => {

    const theme = useTheme();
    const ismobile = useMediaQuery(theme.breakpoints.down("sm"))

    const handleUpdate = (item) => {
        props.setdataupdate(item, () => {
            props.setopenupdate(true);
        });
    }

    return (
        <div>
            <TableContainer component={Paper} sx={{ width: ismobile ? '100%' : 'auto' }}>
                <Table size={ismobile ? 'small' : ''} sx={{ margin: "40px 0" }}>
                    <TableHead>
                        <TableRow>
                            {
                                tablerow.map((item, index) => {
                                    return (
                                        <TableCell key={index} align='left'>
                                            {item}
                                        </TableCell>
                                    )
                                })
                            }

                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {
                            props.dataaddress.map((item, index) => {
                                return (
                                    <TableRow key={index}>
                                        <TableCell>
                                            {item.id}
                                        </TableCell>
                                        <TableCell>
                                            {item.street}
                                        </TableCell>
                                        <TableCell>
                                            {item.city}
                                        </TableCell>
                                        <TableCell>
                                            {item.countryCodentry}
                                        </TableCell>
                                        <TableCell>
                                            {item.number}
                                        </TableCell>
                                        <TableCell>
                                            {item.zipcode}
                                        </TableCell>
                                        <TableCell>
                                            <IconButton sx={{ color: '#ffc107' }}
                                                onClick={() => props.handleUpdate(item)}
                                            >
                                                <EditIcon />
                                            </IconButton>
                                            <IconButton sx={{ color: '#f44336' }}>
                                                <DeleteIcon />
                                            </IconButton>
                                        </TableCell>
                                    </TableRow>
                                )
                            })
                        }

                    </TableBody>
                </Table>
            </TableContainer>
        </div>
    );
};

export default TableAddress;