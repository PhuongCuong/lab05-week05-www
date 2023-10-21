import { Draw } from '@mui/icons-material';
import { Drawer, List, ListItem, ListItemButton, ListItemIcon, Typography, useMediaQuery, useTheme } from '@mui/material';
import React, { useState } from 'react';
import PersonOutlineIcon from '@mui/icons-material/PersonOutline';
import AssignmentIcon from '@mui/icons-material/Assignment';
import WorkIcon from '@mui/icons-material/Work';
import ExplicitIcon from '@mui/icons-material/Explicit';
import { To, Link as ReactRouterLink } from 'react-router-dom'
import PlaceIcon from '@mui/icons-material/Place';


const obj = [
    { label: "Address", value: 0, icon: <PlaceIcon />, path: '/address' },
    { label: "Candidate", value: 1, icon: <PersonOutlineIcon />, path: '/candidate' },
    { label: "Skill", value: 2, icon: <AssignmentIcon />, path: '/skill' },
    { label: "Job", value: 3, icon: <WorkIcon />, path: '/job' },
    { label: "Experience", value: 4, icon: <ExplicitIcon />, path: '/experience' },

]


const Draws = (props) => {

    const theme = useTheme();
    const mobile = useMediaQuery(theme.breakpoints.down("sm"))

    return (
        <React.Fragment>
            <Drawer PaperProps={{ sx: { width: "25%" } }} open={props.open} onClose={() => props.setopen(false)}>
                <List>
                    {
                        obj.map((item, index) => {
                            return (
                                <ListItem key={index} sx={{ marginBottom: "10px" }}
                                >
                                    <ListItemButton
                                        onClick={() => props.setopen(false)}
                                        component={ReactRouterLink} to={item.path}
                                    >
                                        <ListItemIcon>
                                            {item.icon}
                                            <Typography sx={{ marginLeft: "5px", display: mobile ? 'none' : 'block' }}>
                                                {item.label}
                                            </Typography>
                                        </ListItemIcon>
                                    </ListItemButton>
                                </ListItem>
                            )
                        })
                    }
                </List>



            </Drawer>
        </React.Fragment>
    );
};

export default Draws;