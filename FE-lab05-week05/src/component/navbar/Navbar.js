import { AppBar, Avatar, Box, IconButton, Tab, Tabs, Toolbar, useMediaQuery, useTheme } from '@mui/material';
import React, { useState } from 'react';
import HomeIcon from '@mui/icons-material/Home';
import PersonOutlineIcon from '@mui/icons-material/PersonOutline';
import AssignmentIcon from '@mui/icons-material/Assignment';
import WorkIcon from '@mui/icons-material/Work';
import ExplicitIcon from '@mui/icons-material/Explicit';
import MenuIcon from '@mui/icons-material/Menu';
import Draws from './Draws';
import LogoutIcon from '@mui/icons-material/Logout';
import { Link } from 'react-router-dom';
import PlaceIcon from '@mui/icons-material/Place';

import './Navbar.scss'

const obj = [
    { label: "Address", value: 0, icon: <PlaceIcon />, path: '/address' },
    { label: "Candidate", value: 1, icon: <PersonOutlineIcon />, path: '/candidate' },
    { label: "Skill", value: 2, icon: <AssignmentIcon />, path: '/skill' },
    { label: "Job", value: 3, icon: <WorkIcon />, path: '/job' },
    { label: "Experience", value: 4, icon: <ExplicitIcon />, path: '/experience' },

]


const Navbar = () => {


    const [value, setvalue] = useState(0);

    const [open, setopen] = useState(false);

    const theme = useTheme();

    const tablet = useMediaQuery(theme.breakpoints.down('md'))


    return (
        <AppBar position='static'>
            <Toolbar>
                <Tabs value={value} indicatorColor='secondary' aria-label="basic tabs example"
                    sx={{ display: tablet ? 'none' : 'block' }}
                >
                    {
                        obj.map((item, index) => {
                            return (

                                <Tab
                                    key={index}
                                    label={item.label}
                                    icon={item.icon}
                                    iconPosition="start"
                                    value={item.value}
                                    onClick={() => setvalue(item.value)}
                                    component={Link}
                                    to={item.path}
                                />

                            )
                        })
                    }
                </Tabs>
                <IconButton sx={{ display: tablet ? 'block' : 'none' }} color="secondary" aria-label="add an alarm" onClick={() => setopen(true)}>
                    <MenuIcon />
                </IconButton>
                <Box sx={{ display: 'flex', justifyContent: 'center', alignItems: 'center', marginLeft: 'auto' }}>
                    <Avatar sx={{ marginRight: "15px" }} alt="Remy Sharp" src="/static/images/avatar/1.jpg" />
                    <IconButton>
                        <LogoutIcon />
                    </IconButton>
                </Box>
            </Toolbar>
            <Draws
                open={open}
                setopen={setopen}
            />
        </AppBar >
    );
};

export default Navbar;