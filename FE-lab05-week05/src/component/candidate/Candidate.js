import { AppBar, Box, Button, IconButton, Paper, Table, TableBody, TableCell, TableContainer, TableHead, TableRow, Toolbar, Typography, useMediaQuery, useTheme } from '@mui/material';
import React from 'react';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import AddCircleIcon from '@mui/icons-material/AddCircle';

const tablerow = [
    "can_id", "dob", "email", "full_name", "phone", "address", "actions"
]

const Candidate = () => {

    const theme = useTheme();
    const ismobile = useMediaQuery(theme.breakpoints.down("sm"))

    return (
        <Box sx={{
            backgroundColor: "#efefef",
            width: "100%",
            height: "100vh",
            position: 'fixed',
        }}>
            <Box sx={{
                backgroundColor: "white",
                width: "100%",
                position: 'fixed',
                display: "flex"
            }}>
                <Typography sx={{ margin: "10px", fontSize: "18px", fontWeight: "550" }}>Danh Sách Candidate</Typography>
                <Button variant='contained' sx={{
                    marginLeft: "auto",
                    marginRight: "20px",
                    width: "200px",
                    height: "40px",
                    marginTop: "10px",
                    marginBottom: "10px"
                }}>
                    <AddCircleIcon />
                    <Typography sx={{ margin: "10px", fontSize: "13x", fontWeight: "550" }}>Thêm mới</Typography>
                </Button>
            </Box>
            <TableContainer component={Paper} sx={{ width: ismobile ? '100%' : 'auto' }}>
                <Table sx={{ margin: "40px 0" }}>
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
                        <TableRow>
                            <TableCell>
                                1
                            </TableCell>
                            <TableCell>
                                16/10/2023
                            </TableCell>
                            <TableCell>
                                cuong@gmail.com
                            </TableCell>
                            <TableCell>
                                nguyen phuong cuong
                            </TableCell>
                            <TableCell>
                                0367201132
                            </TableCell>
                            <TableCell>
                                hai duong
                            </TableCell>
                            <TableCell>
                                <IconButton sx={{ color: '#ffc107' }}>
                                    <EditIcon />
                                </IconButton>
                                <IconButton sx={{ color: '#f44336' }}>
                                    <DeleteIcon />
                                </IconButton>
                            </TableCell>
                        </TableRow>
                    </TableBody>
                </Table>
            </TableContainer>
        </Box >
    );
};

export default Candidate;